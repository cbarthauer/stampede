package sonar;

import analyzer.AntlrRoutineProcessor;
import analyzer.InMemoryMetricStore;
import analyzer.Metric;
import analyzer.MetricListener;
import analyzer.MetricResult;
import analyzer.MetricStore;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import listener.LineCountListener;
import java.util.Iterator;
import java.util.List;
import main.MumpsAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.File;
import org.sonar.api.resources.InputFile;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Qualifiers;

/**
 * This class analyzes a MUMPS source distribution stored in the file system and
 * loads the results into Sonar.
 *
 * @author cbarthauer
 */
public final class MumpsSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(MumpsSensor.class);

    @Override
    public final boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public final void analyse(Project project, SensorContext context) {
        String qualifier = project.getQualifier();

        if (Qualifiers.PROJECT.equals(qualifier)) {
            analyseProject(project, context);
        } else if (Qualifiers.MODULE.equals(qualifier)) {
            analyseModule(project, context);
        }
    }

    private Iterator<MetricResult> getMetricResultIterator(List<InputFile> inputFiles) {
        final SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        final MetricListener listener = new LineCountListener();
        final RoutineProcessor processor = new AntlrRoutineProcessor(listener);
        MetricStore store = new InMemoryMetricStore();
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        store = analyzer.analyze();
        return store.iterator();
    }

    private void analyseModule(Project project, SensorContext context) {
        List<InputFile> inputFiles = project.getFileSystem().mainFiles(Mumps.KEY);
        Iterator<MetricResult> iterator = getMetricResultIterator(inputFiles);

        while (iterator.hasNext()) {
            MetricResult result = iterator.next();
            File sonarFile = File.fromIOFile(
                    new java.io.File(result.getPath()),
                    project);

            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());

            context.saveMeasure(
                    sonarFile,
                    CoreMetrics.LINES,
                    result.getDouble(Metric.LOC));
        }
    }

    private void analyseProject(Project project, SensorContext context) {
        //Not implemented.
    }
}
