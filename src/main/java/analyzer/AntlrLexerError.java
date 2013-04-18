/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;

/**
 * This class represents a lexer error occurring while lexing
 * MUMPS source code.
 * 
 * @author cbarthauer
 */
public final class AntlrLexerError {
    private final String identifier;
    private final String message;
    private final int line;
    private final int charPositionInLine;
    
    public AntlrLexerError(
            String identifier,
            String message,
            int line,
            int charPositionInLine) {
        this.identifier = identifier;
        this.message = message;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }
    
    public final int getCharPositionInLine() {
        return charPositionInLine;
    }
    
    public final String getIdentifier() {
        return identifier;
    }
    
    public final int getLine() {
        return line;
    }
    
    public final String getMessage() {
        return message;
    }
}
