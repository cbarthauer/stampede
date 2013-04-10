/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cbarthauer
 */
public class InMemoryMetricStoreTest {
    
    @Test
    public void iterateTwoMetricResults() {
        InMemoryMetricStore store = new InMemoryMetricStore();
        
        Map<Metric, Integer> metricMap1 = new HashMap<Metric, Integer>();
        metricMap1.put(Metric.LOC, 1);
        
        Map<Metric, Integer> metricMap2 = new HashMap<Metric, Integer>();
        metricMap2.put(Metric.LOC, 2);
        
        Map<String, Map<Metric, Integer>> idMap = 
                new LinkedHashMap<String, Map<Metric, Integer>>();
        idMap.put("file1", metricMap1);
        idMap.put("file2", metricMap2);
        
        store.append(idMap);
        assertThat(3, equalTo(store.sum(Metric.LOC)));
        
        Iterator<MetricResult> iterator = store.iterator();
        MetricResult result = iterator.next();
        assertThat(result.getPath(), equalTo("file1"));
        assertThat(result.getDouble(Metric.LOC), equalTo(1.0));
        
        result = iterator.next();
        assertThat(result.getPath(), equalTo("file2"));
        assertThat(result.getDouble(Metric.LOC), equalTo(2.0));
    }
}
