package analyzer;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MapBasedMetricResultTest {
    
    @Test
    public void shouldReturnEmptyMetricSetForEmptyResult() {
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        MetricResult result = new MapBasedMetricResult(null, metricMap);
        assertThat(result.getSupportedMetrics().size(), equalTo(0));       
    }
    
    @Test
    public void shouldReturnSupportedMetrics() {
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        metricMap.put(Metric.LOC, 0);
        MetricResult result = new MapBasedMetricResult(null, metricMap);
        assertThat(result.getSupportedMetrics().size(), equalTo(1));
    }
}
