package analyzer;

/**
 * This class represents a lexer error occurring while lexing
 * MUMPS source code. Instances of this class are immutable.
 * 
 * @author cbarthauer
 */
public final class AntlrLexerError {
    private final String identifier;
    private final String message;
    private final int line;
    private final int charPositionInLine;
    
    /**
     * Create a new lexer error.
     * 
     * @param identifier Uniquely identifies the containing
     *     MUMPS routine
     * @param message ANTLR lexer error message
     * @param line Line number where error occurred
     * @param charPositionInLine Character position in line where
     *     error occurred
     */
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
    
    /**
     * Get the character position of the lexer error.
     * 
     * @return Numeric value of character position
     */
    public final int getCharPositionInLine() {
        return charPositionInLine;
    }
    
    /**
     * Get the unique identifier for the MUMPS routine
     * containing this lexer error.
     * 
     * @return Unique identifier
     */
    public final String getIdentifier() {
        return identifier;
    }
    
    /**
     * Get the line number where the lexer error occurs.
     * 
     * @return Numeric value of line number
     */
    public final int getLine() {
        return line;
    }
    
    /**
     * Get the text of the lexer error message.
     * 
     * @return Lexer error message
     */
    public final String getMessage() {
        return message;
    }

    @Override
    public final String toString() {
        return "[" + identifier 
                + "," + line 
                + "," + charPositionInLine 
                + "," + message 
                + "]";
    }
}
