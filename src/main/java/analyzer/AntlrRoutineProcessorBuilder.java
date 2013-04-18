package analyzer;

/**
 * This class builds instances of AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessorBuilder {
    private AntlrLexerErrorListener errorListener;

    public final AntlrRoutineProcessorBuilder setLexerErrorListener(
            AntlrLexerErrorListener errorListener) {
        this.errorListener = errorListener;
        return this;
    }

    public final AntlrRoutineProcessor build() {
        return new AntlrRoutineProcessor(errorListener);
    }
   
}
