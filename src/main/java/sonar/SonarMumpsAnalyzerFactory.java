package sonar;

import analyzer.AntlrRoutineProcessorBuilder;
import analyzer.InMemoryLexerErrorListener;
import analyzer.InMemoryMetricStore;
import analyzer.LexerErrorListener;
import analyzer.MetricListener;
import analyzer.MetricStore;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import listener.LineCountListener;
import listener.PrintStreamLexerErrorListener;
import main.MumpsAnalyzer;
import org.sonar.api.resources.InputFile;

/**
 * A factory for creating MumpsAnalyzer objects suitable for use within
 * the Sonar MumpsSensor class.
 * 
 * @author cbarthauer
 */
final class SonarMumpsAnalyzerFactory {

    /**
     * Creates a MumpsAnalyzer for the give inputFiles. The MumpsAnalyzer
     * is suitable for use within the Sonar MumpsSensor.
     * 
     * @param inputFiles List of MUMPS source files from Sonar.
     * @return A properly initialized MumpsAnalyzer.
     */
    static MumpsAnalyzer getMumpsAnalyzer(List<InputFile> inputFiles) {
        final SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        final MetricListener metricListener = new LineCountListener();
        final LexerErrorListener lexerListener = getLexerErrorListener();
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = builder.setMetricListeners(metricListener)
                .setLexerErrorListener(lexerListener)
                .build();
        MetricStore store = new InMemoryMetricStore();
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        return analyzer;
    }
    
    private static LexerErrorListener getLexerErrorListener() {
        PrintStream out = System.out;
        
        try {
            out = new PrintStream(new java.io.File("lexer_errors.log"));
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to create lexer_errors.log; redirecting lexer errors to System.out.");
        }
        
        return new PrintStreamLexerErrorListener(
                out, 
                new InMemoryLexerErrorListener());
    }
    
    private SonarMumpsAnalyzerFactory() {
        //Hide utility class constructor.
    }   
    
}
