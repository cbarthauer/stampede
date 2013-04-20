package analyzer;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * This class records lexer errors for AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class InMemoryLexerErrorListener extends BaseErrorListener 
        implements LexerErrorListener {

    private MumpsRoutine routine;
    private final List<AntlrLexerError> errors;
    
    /**
     * Creates InMemoryLexerErrorListener and initializes in-memory
     * data structure.
     */
    public InMemoryLexerErrorListener() {
        this.routine = new NullMumpsRoutine();
        this.errors = new ArrayList<AntlrLexerError>();
    }
    
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {
        
        errors.add(
                new AntlrLexerError(
                    routine.identifier(),
                    msg,
                    line,
                    charPositionInLine));
    }
    
    @Override
    public final List<AntlrLexerError> getLexerErrors() {
        return new ArrayList<AntlrLexerError>(errors);
    }
    
    @Override
    public final void setMumpsRoutine(MumpsRoutine routine) {
        this.routine = routine;
    }
    
    private final class NullMumpsRoutine implements MumpsRoutine {

        @Override
        public final String asString() {
            return "";
        }

        @Override
        public final String identifier() {
            return "";
        }
        
    }
}
