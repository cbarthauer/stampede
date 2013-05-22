package sonar;

import analyzer.MetricResult;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

/**
 * MumpsSensor uses a list of MetricResultHandler objects
 * to handle results obtained from STAMPEDE.
 * 
 * @author cbarthauer
 */
public interface MetricResultHandler {

    /**
     * Save the given metricResults in Sonar.
     * 
     * @param project associated with metricResults
     * @param sensorContext in which to save results
     * @param metricResults to be saved
     */
    public void save(
            Project project, 
            SensorContext sensorContext, 
            List<MetricResult> metricResults);
    
}
