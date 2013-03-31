package main;

import analyzer.AntlrRoutineProcessor;
import analyzer.FileSystemSourceDistribution;
import analyzer.InMemoryMetricStore;
import analyzer.Metric;
import analyzer.MetricListener;
import analyzer.MetricStore;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import grammar.LineCountListener;
import java.io.File;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

public class MumpsAnalyzerTest { 
    private final String MUMPS_FILE_PATH 
            = "D:\\mspace\\VistA-FOIA\\Packages\\Toolkit\\Routines\\XINDEX.m";
    private final String MUMPS_FOLDER_PATH
            = "D:\\mspace\\VistA-FOIA\\Packages\\Accounts Receivable\\Routines";
    
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    
    
    @Test
    public void analyzeSkeleton() {
        final SourceDistribution distribution = context.mock(SourceDistribution.class);
        final RoutineProcessor processor = context.mock(RoutineProcessor.class);
        final MetricStore store = context.mock(MetricStore.class);
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        
        context.checking(new Expectations() {{
            oneOf(distribution).iterator();
            never(processor).process(with(any(MumpsRoutine.class)));
            never(store).write(with(any(Map.class)));
            oneOf(store).clone();
        }});
        
        MetricStore result = analyzer.analyze();        
        assertThat(result.sum(Metric.LOC), equalTo(0));
    }
    
    @Test
    public void analyzeOneRoutine() {
        final File inputFile = new File(MUMPS_FILE_PATH);
        final SourceDistribution distribution = 
                new FileSystemSourceDistribution(inputFile);
        final MetricListener listener = new LineCountListener();
        final RoutineProcessor processor = new AntlrRoutineProcessor(listener);
        final MetricStore store = new InMemoryMetricStore();
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution, 
                processor, 
                store);
        
        MetricStore result = analyzer.analyze();
        assertThat(result.sum(Metric.LOC), equalTo(144));
    }
    
    @Test
    public void analyzeFolderOfRoutines() {
        final File inputFile = new File(MUMPS_FOLDER_PATH);
        final SourceDistribution distribution = 
                new FileSystemSourceDistribution(inputFile);
        final MetricListener listener = new LineCountListener();
        final RoutineProcessor processor = new AntlrRoutineProcessor(listener);
        final MetricStore store = new InMemoryMetricStore();
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution, 
                processor, 
                store);
        
        MetricStore result = analyzer.analyze();
        assertThat(result.sum(Metric.LOC), equalTo(44620));
    }
}
