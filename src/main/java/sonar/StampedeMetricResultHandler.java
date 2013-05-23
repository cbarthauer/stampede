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
import java.util.List;
import java.util.Map;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;

/**
 * This class saves all core STAMPEDE metric results using the
 * Sonar API.
 * 
 * @author cbarthauer
 */
final class StampedeMetricResultHandler 
        implements MetricResultHandler {

    private Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap;
    
    /**
     * Create a StampedeMetricResultHandler which will use the given
     * map to look up the Sonar metric equivalents to STAMPEDE metrics.
     * 
     * @param sonarMetricMap contains mappings between STAMPEDE
     * metrics and Sonar metrics.
     */
    StampedeMetricResultHandler(
            Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap) {
        this.sonarMetricMap = sonarMetricMap;
    }
    
    @Override
    public final void save(
            Project project, 
            SensorContext context, 
            List<MetricResult> metricResults) {
        
        for (MetricResult result : metricResults) {
            File sonarFile = File.fromIOFile(
                    new java.io.File(result.getPath()),
                    project);

            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());
            
            for(Metric metric : result.getSupportedMetrics()) {
                context.saveMeasure(
                        sonarFile,
                        sonarMetricMap.get(metric),
                        result.getDouble(metric));
            }
        }
    }

}
