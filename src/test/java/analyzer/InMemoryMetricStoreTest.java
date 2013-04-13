/**
 * Copyright (C) 2013 Chris Barthauer <cbarthauer@gmail.com>
 *
 * This file is part of MumpsAnalyzer.
 *
 * MumpsAnalyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MumpsAnalyzer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MumpsAnalyzer.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
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
