package analyzer;

import java.util.Iterator;
import java.util.Map;

/**
 * This interface models a collection of metric values. The 
 * underlying data structure should contain the results of
 * analyzing MUMPS source code.
 * 
 * @author cbarthauer
 */
public interface MetricStore {
    /**
     * Create an exact copy of this MetricStore.
     * 
     * @return An equivalent MetricStore.
     */
    public MetricStore clone();
    
    /**
     * Returns an iterator suitable for enumerating the
     * analysis results.
     * 
     * @return An iterator object.
     */
    public Iterator<MetricResult> iterator();
    
    /**
     * Calculate the sum of values stored for the given Metric.
     * 
     * @param metric of interest.
     * @return The sum for the given Metric.
     */
    public int sum(Metric metric);
    
    /**
     * Append the data in the given resultMap to the MetricStore.
     * 
     * @param resultMap containing the data to append.
     */
    public void append(Map<String, Map<Metric, Integer>> resultMap);
}
