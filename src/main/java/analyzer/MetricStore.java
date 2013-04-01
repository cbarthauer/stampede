package analyzer;

import java.util.Map;

public interface MetricStore {
    public MetricStore clone();
    public int sum(Metric metric);
    public void write(Map<String, Map<Metric, Integer>> resultMap);
}
