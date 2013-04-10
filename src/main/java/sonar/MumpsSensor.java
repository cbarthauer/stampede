package sonar;

import analyzer.AntlrRoutineProcessor;
import analyzer.FileSystemSourceDistribution;
import analyzer.InMemoryMetricStore;
import analyzer.Metric;
import analyzer.MetricListener;
import analyzer.MetricResult;
import analyzer.MetricStore;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import grammar.LineCountListener;
import java.util.Iterator;
import main.MumpsAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;

public final class MumpsSensor implements Sensor {
    private static final Logger LOG = LoggerFactory.getLogger(MumpsSensor.class);

    @Override
    public final boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public final void analyse(Project project, SensorContext context) {
        final String MUMPS_FOLDER_PATH
            = "D:\\mspace\\VistA-FOIA\\Packages\\Accounts Receivable\\Routines";
        final java.io.File inputFile = new java.io.File(MUMPS_FOLDER_PATH);
        final SourceDistribution distribution = 
                new FileSystemSourceDistribution(inputFile);
        final MetricListener listener = new LineCountListener();
        final RoutineProcessor processor = new AntlrRoutineProcessor(listener);
        MetricStore store = new InMemoryMetricStore();
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution, 
                processor, 
                store);
        
        store = analyzer.analyze();
        Iterator<MetricResult> iterator = store.iterator();
        
        while(iterator.hasNext()) {
            MetricResult result = iterator.next();
            LOG.info("MetricResult - Path: " + result.getPath());
            LOG.info("MetricResult - LOC: " + result.getDouble(Metric.LOC));
            
            File sonarFile = File.fromIOFile(
                    new java.io.File(result.getPath()), 
                    project);
            
            if(sonarFile != null) {
                sonarFile.setEffectiveKey(
                        "VistA-FOIA:accountsReceivable:" + sonarFile.getKey());

                LOG.info("sonarFile - Key: " + sonarFile.getKey());
                LOG.info("sonarFile - Effective Key: " + sonarFile.getEffectiveKey());

                context.saveMeasure(
                        sonarFile, 
                        CoreMetrics.LINES, 
                        result.getDouble(Metric.LOC));
            }
            else {
                LOG.info("sonarFile is null!");
            }
        }
    }
}
