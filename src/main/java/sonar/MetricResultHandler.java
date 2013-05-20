package sonar;

import analyzer.MetricResult;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

/**
 *
 * @author cbarthauer
 */
public interface MetricResultHandler {

    public void save(
            Project project, 
            SensorContext sensorContext, 
            List<MetricResult> metricResults);
    
}
