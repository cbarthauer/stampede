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

import analyzer.MumpsSyntaxError;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;

/**
 * This class saves M syntax errors in Sonar as violations.
 * 
 * @author cbarthauer
 */
final class SyntaxErrorViolationHandler
        implements SyntaxErrorHandler {
    
    private final RuleFinder ruleFinder;

    /**
     * Create a new SyntaxErrorViolationHandler initialized
     * with the given ruleFinder.
     * 
     * @param ruleFinder used to locate syntaxError rule.
     */
    SyntaxErrorViolationHandler(RuleFinder ruleFinder) {
        this.ruleFinder = ruleFinder;
    }

    @Override
    public final void save(
            Project project, 
            SensorContext context, 
            List<MumpsSyntaxError> syntaxErrors) {
        
        Rule rule = ruleFinder.findByKey(MumpsRuleRepository.KEY, "syntaxError");
        
        for(MumpsSyntaxError error : syntaxErrors) {
            File sonarFile = File.fromIOFile(
                    new java.io.File(error.getIdentifier()),
                    project);
            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());
            Violation violation = Violation.create(rule, sonarFile)
                    .setLineId(error.getLine())
                    .setMessage("[line: " + error.getLine() 
                        + ", column: " + error.getCharPositionInLine() 
                        + "] " + error.getMessage());
            context.saveViolation(violation);
        }
    }
}
