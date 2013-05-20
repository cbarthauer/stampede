package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;

/**
 *
 * @author cbarthauer
 */
public final class StampedeMetricResultHandler 
        implements MetricResultHandler {

    private SonarMetricMap sonarMetricMap;
    
    public StampedeMetricResultHandler(SonarMetricMap sonarMetricMap) {
        this.sonarMetricMap = sonarMetricMap;
    }
    
    @Override
    public final void save(
            Project project, 
            SensorContext context, 
            List<MetricResult> metricResults) {
        
        for (MetricResult result : metricResults) {
            File sonarFile = File.fromIOFile(
                    new java.io.File(result.getPath()),
                    project);

            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());
            
            for(Metric metric : result.getSupportedMetrics()) {
                context.saveMeasure(
                        sonarFile,
                        sonarMetricMap.get(metric),
                        result.getDouble(metric));
            }
        }
    }

}
