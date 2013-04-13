package analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class models a MetricStore backed by a data structure stored on
 * the heap.
 * 
 * @author cbarthauer
 */
public final class InMemoryMetricStore implements MetricStore {
    private Map<String, Map<Metric, Integer>> metricsByIdentifier;
    
    /**
     * Creates and initializes an InMemoryMetricStore object.
     */
    public InMemoryMetricStore() {
        this.metricsByIdentifier = new LinkedHashMap<String, Map<Metric, Integer>>();
    }
    
    @Override
    public final MetricStore clone() {
        MetricStore result = new InMemoryMetricStore();
        result.append(metricsByIdentifier);
        return result;
    }

    @Override
    public Iterator<MetricResult> iterator() {
        List<MetricResult> result = new ArrayList<MetricResult>();
        
        for(String id : metricsByIdentifier.keySet()) {
            Map<Metric, Integer> metricMap = metricsByIdentifier.get(id);
            result.add(new MapBasedMetricResult(id, metricMap));
        }
        
        return result.iterator();
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
    public final void append(Map<String, Map<Metric, Integer>> resultMap) {
        this.metricsByIdentifier.putAll(resultMap);
    }    
}
