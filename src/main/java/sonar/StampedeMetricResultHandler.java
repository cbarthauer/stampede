package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import java.util.List;
import java.util.Map;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;

/**
 * This class saves all core STAMPEDE metric results using the
 * Sonar API.
 * 
 * @author cbarthauer
 */
public final class StampedeMetricResultHandler 
        implements MetricResultHandler {

    private Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap;
    
    /**
     * Create a StampedeMetricResultHandler which will use the given
     * map to look up the Sonar metric equivalents to STAMPEDE metrics.
     * 
     * @param sonarMetricMap contains mappings between STAMPEDE
     * metrics and Sonar metrics.
     */
    public StampedeMetricResultHandler(
            Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap) {
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
