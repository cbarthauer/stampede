package listener;

import analyzer.MumpsRoutine;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author cbarthauer
 */
public final class InMemoryParserErrorListener extends BaseErrorListener
        implements ParserErrorListener {
    
    private MumpsRoutine routine;
    private final List<AntlrError> errors;

    public InMemoryParserErrorListener() {
        this.routine = new NullMumpsRoutine();
        this.errors = new ArrayList<AntlrError>();
    }
    
    @Override
    public final void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {
        
        errors.add(
                new AntlrError(
                    routine.identifier(),
                    msg,
                    line,
                    charPositionInLine));
    }
    
    @Override
    public final List<AntlrError> getParserErrors() {
        return new ArrayList<AntlrError>(errors);
    }

    @Override
    public void setMumpsRoutine(MumpsRoutine routine) {
        this.routine = routine;
    }
    
}
