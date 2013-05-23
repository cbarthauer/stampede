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
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MapBasedMetricResultTest {
    
    @Test
    public void shouldReturnEmptyMetricSetForEmptyResult() {
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        MetricResult result = new MapBasedMetricResult(null, metricMap);
        assertThat(result.getSupportedMetrics().size(), equalTo(0));       
    }
    
    @Test
    public void shouldReturnSupportedMetrics() {
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        metricMap.put(Metric.LOC, 0);
        MetricResult result = new MapBasedMetricResult(null, metricMap);
        assertThat(result.getSupportedMetrics().size(), equalTo(1));
    }
}
