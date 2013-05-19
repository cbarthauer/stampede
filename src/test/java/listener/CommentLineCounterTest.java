package listener;

import analyzer.Metric;
import analyzer.MumpsRoutine;
import analyzer.StringBasedMumpsRoutine;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static analyzer.AntlrRoutineProcessorFactory.*;
import analyzer.RoutineProcessor;
import org.junit.Before;

public class CommentLineCounterTest {
    
    private RoutineProcessor processor;
    
    @Before
    public void setup() {
        processor = getRoutineProcessor(new CommentLineCounter());
    }
    
    @Test
    public void shouldCountCommentLinesWithBlockLevelIndicators() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                " ... ; Comment with block level indicators.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));        
    }
    
    @Test
    public void shouldIgnoreLineWithCommand() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                " Q ; Has command.",
                " ; Just a comment.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));
    }
    
    @Test
    public void shouldIgnoreLineWithEntryLabel() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.",
                " ; Just a comment.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));
    }
    
    @Test
    public void shouldResetAfterEachRoutine() {
        final MumpsRoutine routine1 = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.",
                " ; Comment only.");
        Map<String, Map<Metric, Integer>> results1 = processor.process(routine1);
        assertThat(results1.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));

        final MumpsRoutine routine2 = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.");
        Map<String, Map<Metric, Integer>> results2 = processor.process(routine2);
        assertThat(results2.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(0));
    }
    
    @Test
    public void shouldReturnZeroForEmptyRoutine() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(0));
    }

}
