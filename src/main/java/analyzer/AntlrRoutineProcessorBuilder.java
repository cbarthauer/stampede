package analyzer;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;

/**
 * This class builds instances of AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessorBuilder {
    private LexerErrorListener errorListener;
    private MetricListener[] metricListeners;

    /**
     * Creates a builder instance with no MetricListeners
     * and a no-op LexerErrorListener. 
     */
    public AntlrRoutineProcessorBuilder() {
        errorListener = new NullLexerErrorListener();
        metricListeners = new MetricListener[]{};
    }
    
    /**
     * Create an AntlrRoutineProcessor using the components specified
     * by the setXXX(...) methods.
     * 
     * @return An AntlrRoutineProcessor properly initialized.
     */
    public final AntlrRoutineProcessor build() {
        return new AntlrRoutineProcessor(
                errorListener,
                metricListeners);
    }
    
    /**
     * Register the given LexerErrorListener with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param errorListener to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setLexerErrorListener(
            LexerErrorListener errorListener) {
        this.errorListener = errorListener;
        return this;
    }

    /**
     * Register the given MetricListeners with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param metricListeners to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setMetricListeners(
            MetricListener... metricListeners) {
        this.metricListeners = metricListeners;
        return this;
    }
    
    private final class NullLexerErrorListener extends BaseErrorListener 
            implements LexerErrorListener {

        @Override
        public final List<AntlrLexerError> getLexerErrors() {
            return new ArrayList<AntlrLexerError>();
        }

        @Override
        public final void setMumpsRoutine(MumpsRoutine routine) {
            //No-op;
        }
        
    }
}
