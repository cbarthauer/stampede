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
public final class AntlrLexerErrorListener extends BaseErrorListener {

    private final String identifier;
    private final List<AntlrLexerError> errors;
    
    public AntlrLexerErrorListener(String identifier) {
        this.identifier = identifier;
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
                    identifier,
                    msg,
                    line,
                    charPositionInLine));
    }
    
    public final List<AntlrLexerError> getLexerErrors() {
        return new ArrayList<AntlrLexerError>(errors);
    }
}
