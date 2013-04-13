package analyzer;

import java.util.HashMap;
import java.util.Map;

class MapBasedMetricResult implements MetricResult {
    private final String id;
    private final HashMap<Metric, Integer> metricMap;

    /**
     * Creates a MapBasedMetricResult backed by the data contained in
     * metricMap.
     * 
     * @param id A unique identifier for this result.
     * @param metricMap A map containing the Metric data.
     */
    MapBasedMetricResult(String id, Map<Metric, Integer> metricMap) {
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
