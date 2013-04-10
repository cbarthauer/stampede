package analyzer;

import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

public class AntlrRoutineProcessorTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    
    @Test
    public void mockCountLines() {
        final MumpsRoutine routine = context.mock(MumpsRoutine.class);
        final MetricListener listener = context.mock(MetricListener.class);
        
        RoutineProcessor processor = 
                new AntlrRoutineProcessor(listener);
        
        context.checking(new Expectations() {{
            oneOf(routine).asString();
            will(returnValue("HELLO ; This is a comment.\n"));
            oneOf(listener).asMListener();
            oneOf(listener).getMetric();
            will(returnValue(Metric.LOC));
            oneOf(listener).getValue();
            will(returnValue(1));
            oneOf(routine).identifier();
            will(returnValue("HELLO.m"));
            oneOf(listener).reset();
        }});
        
        processor.process(routine);
    }
}
