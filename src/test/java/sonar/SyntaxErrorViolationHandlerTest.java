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
import java.util.Arrays;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import org.junit.Rule;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;
import utils.TestingConstants;

public class SyntaxErrorViolationHandlerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery(); 

    @Test
    public void shouldIgnoreEmptySyntaxErrorList() {
        final RuleFinder ruleFinder = context.mock(RuleFinder.class);
        final SyntaxErrorHandler handler = new SyntaxErrorViolationHandler(ruleFinder);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final List<MumpsSyntaxError> syntaxErrors = context.mock(List.class);
        
        context.checking(new Expectations() {{
            oneOf(ruleFinder).findByKey(MumpsRuleRepository.KEY, "syntaxError");
            oneOf(syntaxErrors).iterator();
            never(sensorContext).saveViolation(with(any(Violation.class)));
        }});
        
        handler.save(null, null, syntaxErrors);
    }
    
    @Test
    public void shouldSaveSyntaxErrorAsViolation() {
        final RuleFinder ruleFinder = context.mock(RuleFinder.class);
        final SyntaxErrorHandler handler = new SyntaxErrorViolationHandler(ruleFinder);
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final MumpsSyntaxError error = context.mock(MumpsSyntaxError.class);
        final List<MumpsSyntaxError> syntaxErrors = Arrays.asList(error);
        
        context.checking(new Expectations() {{
            oneOf(ruleFinder).findByKey(MumpsRuleRepository.KEY, "syntaxError");
            oneOf(error).getIdentifier();
            will(returnValue(TestingConstants.VISTA_XINDEX_PATH));
            exactly(2).of(error).getLine();
            will(returnValue(1));
            oneOf(error).getCharPositionInLine();
            oneOf(error).getMessage();
            oneOf(sensorContext).saveViolation(with(any(Violation.class)));
        }});
        
        handler.save(project, sensorContext, syntaxErrors);        
    }
}
