/**
 * Copyright (C) 2013 Chris Barthauer <mumpsanalyzer@gmail.com>
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
