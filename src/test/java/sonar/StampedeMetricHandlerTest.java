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
package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import org.junit.Rule;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import utils.TestingConstants;

public class StampedeMetricHandlerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();  
    
    @Test
    public void shouldIgnoreEmptyMetricResults() {
        final MetricResultHandler handler = new StampedeMetricResultHandler(
                new SonarConfiguration(null).getMetricMap());
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final List<MetricResult> metricResults = context.mock(List.class);
        
        context.checking(new Expectations() {{
            oneOf(metricResults).iterator();
            never(sensorContext).saveMeasure(
                    with(any(Resource.class)), 
                    with(any(org.sonar.api.measures.Metric.class)), 
                    with(any(Double.class)));
        }});
        
        handler.save(project, sensorContext, metricResults);
    }
    
    @Test
    public void shouldSaveMetricResult() {
        final MetricResultHandler handler = new StampedeMetricResultHandler(
                new SonarConfiguration(null).getMetricMap());
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final MetricResult result = context.mock(MetricResult.class);
        final List<MetricResult> metricResults = Arrays.asList(result);
        
        context.checking(new Expectations() {{
            oneOf(result).getPath();
            will(returnValue(TestingConstants.VISTA_XINDEX_PATH));
            oneOf(result).getSupportedMetrics();
            will(returnValue(new HashSet<Metric>(Arrays.asList(Metric.LOC))));
            oneOf(result).getDouble(Metric.LOC);
            oneOf(sensorContext).saveMeasure(
                    with(any(Resource.class)), 
                    with(CoreMetrics.LINES), 
                    with(any(Double.class)));
        }});
        
        handler.save(project, sensorContext, metricResults);
    }
    
}
