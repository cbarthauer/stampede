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
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;

/**
 * This class saves a violation in Sonar for any M routine where
 * LOC does not equal NCLOC plus COMMENT_LINES.
 * 
 * @author cbarthauer
 */
final class PhysicalLinesAggregateViolationHandler
        implements MetricResultHandler {

    private final RuleFinder ruleFinder;
    
    /**
     * Create a PhysicalLinesAggregateViolationHandler configured
     * with the give RuleFinder.
     * 
     * @param ruleFinder used to locate physicalLinesAggregate rule.
     */
    PhysicalLinesAggregateViolationHandler(RuleFinder ruleFinder) {
        this.ruleFinder = ruleFinder;
    }
    
    @Override
    public void save(
            Project project, 
            SensorContext context, 
            List<MetricResult> metricResults) {
        
        Rule rule = ruleFinder.findByKey(
                MumpsRuleRepository.KEY, 
                "physicalLinesAggregate");
        
        for(MetricResult result : metricResults) {
            double lines = result.getDouble(Metric.LOC);
            double ncloc = result.getDouble(Metric.NCLOC);
            double commentLines = result.getDouble(Metric.COMMENT_LINES);
            
            if(!(lines == ncloc + commentLines)) {
                File sonarFile = File.fromIOFile(
                        new java.io.File(result.getPath()),
                        project);
                sonarFile.setEffectiveKey(
                        project.getKey() + ":" + sonarFile.getKey());
                Violation violation = Violation.create(rule, sonarFile)
                    .setLineId(1)
                    .setMessage(rule.getDescription());
                context.saveViolation(violation);
            }
        }
    }
}
