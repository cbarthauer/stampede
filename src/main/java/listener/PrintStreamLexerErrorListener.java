package listener;

import analyzer.AntlrLexerError;
import analyzer.InMemoryLexerErrorListener;
import analyzer.LexerErrorListener;
import analyzer.MumpsRoutine;
import java.io.PrintStream;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Notified of lexer errors by AntlrRoutineProcessor. Writes errors to
 * a designated PrintStream.
 * 
 * @author cbarthauer
 */
public final class PrintStreamLexerErrorListener extends BaseErrorListener 
    implements LexerErrorListener {

    private PrintStream out;
    private InMemoryLexerErrorListener wrappedListener;

    /**
     * Constructs a PrintStreamLexerErrorListener which will write lexer
     * errors to the given PrintStream.
     * 
     * @param out PrintStream used to log lexer errors.
     * @param wrappedListener All other method calls delegated to wrapped 
     *      InMemoryLexerErrorListener
     */
    public PrintStreamLexerErrorListener(
            PrintStream out,
            InMemoryLexerErrorListener wrappedListener) {
        this.out = out;
        this.wrappedListener = wrappedListener;
    }

    @Override
    public final void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {

        wrappedListener.syntaxError(
                recognizer, 
                offendingSymbol, 
                line, 
                charPositionInLine, 
                msg, 
                e);
        List<AntlrLexerError> errors = wrappedListener.getLexerErrors();
        out.println(errors.get(errors.size() - 1));
    }

    @Override
    public final List<AntlrLexerError> getLexerErrors() {
        return wrappedListener.getLexerErrors();
    }

    @Override
    public final void setMumpsRoutine(MumpsRoutine routine) {
        wrappedListener.setMumpsRoutine(routine);
    }        
}
