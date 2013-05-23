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
