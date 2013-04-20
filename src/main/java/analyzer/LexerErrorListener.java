package analyzer;

import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;

/**
 * Classes implementing this interface may be registered with an
 * AntlrRoutineProcessor and then notified of lexical errors
 * occurring during MumpsRoutine processing.
 * 
 * @author cbarthauer
 */
public interface LexerErrorListener extends ANTLRErrorListener {
    /**
     * Get a list of lexer errors which occured during MumpsRoutine
     * processing. 
     * 
     * @return List of lexer errors. If no errors, returns an empty
     * list.
     */
    public List<AntlrLexerError> getLexerErrors();
    
    /**
     * Specifies the MumpsRoutine which contains any lexer errors
     * occurring subsequently.
     * 
     * @param routine which contains any subsequent lexer errors.
     */
    public void setMumpsRoutine(MumpsRoutine routine);
}
