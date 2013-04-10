package analyzer;

import java.util.HashMap;
import java.util.Map;

class MapBasedMetricResult implements MetricResult {
    private final String id;
    private final HashMap<Metric, Integer> metricMap;

    public MapBasedMetricResult(String id, Map<Metric, Integer> metricMap) {
        this.id = id;
        this.metricMap = new HashMap<Metric, Integer>(metricMap);
    }

    @Override
    public double getDouble(Metric metric) {
        return metricMap.get(metric);
    }

    @Override
    public String getPath() {
        return id;
    }
    
}
