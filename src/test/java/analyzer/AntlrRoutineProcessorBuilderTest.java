/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;

import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author cbarthauer
 */
public class AntlrRoutineProcessorBuilderTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
        
    @Test
    public void shouldBuildNoOpAntlrRoutineProcessor() {
        final MumpsRoutine routine = context.mock(MumpsRoutine.class);
        AntlrRoutineProcessorBuilder builder = new AntlrRoutineProcessorBuilder();
        AntlrRoutineProcessor processor = builder.build();
        
        context.checking(new Expectations() {{
            oneOf(routine).asString();
            will(returnValue("HELLO ; This is a comment.\n"));
            oneOf(routine).identifier();
            will(returnValue("HELLO.m"));
        }});
        
        Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.size(), equalTo(1));
        assertThat(results.get("HELLO.m").isEmpty(), equalTo(true));
    }
}
