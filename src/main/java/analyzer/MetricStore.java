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

import java.util.Iterator;
import java.util.List;
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

    public List<MetricResult> metricResults();
}
