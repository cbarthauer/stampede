/**
 * Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
 *
 * This file is part of STAMPEDE.
 *
 * STAMPEDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * STAMPEDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
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
