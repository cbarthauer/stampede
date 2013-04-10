package analyzer;

import java.util.Iterator;
import java.util.Map;

public interface MetricStore {
    public MetricStore clone();
    public Iterator<MetricResult> iterator();
    public int sum(Metric metric);
    public void append(Map<String, Map<Metric, Integer>> resultMap);
}
