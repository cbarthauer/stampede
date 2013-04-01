package analyzer;

import java.util.HashMap;
import java.util.Map;

public final class InMemoryMetricStore implements MetricStore {
    private Map<String, Map<Metric, Integer>> metricsByIdentifier;
    
    @Override
    public final MetricStore clone() {
        MetricStore result = new InMemoryMetricStore();
        result.write(metricsByIdentifier);
        return result;
    }

    @Override
    public final int sum(Metric metric) {
        int sum = 0;
        
        for(String identifier : metricsByIdentifier.keySet()) {
            Map<Metric, Integer> metricMap = metricsByIdentifier.get(identifier);
            sum = sum + metricMap.get(metric);
        }
        
        return sum;
    }

    @Override
    public final void write(Map<String, Map<Metric, Integer>> resultMap) {
        this.metricsByIdentifier = 
                new HashMap<String, Map<Metric, Integer>>(resultMap);
    }
    
}
