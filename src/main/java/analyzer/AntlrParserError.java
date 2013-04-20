package analyzer;

/**
 *
 * @author cbarthauer
 */
public final class AntlrParserError {
    private final String identifier;
    private final int line;
    private final String message;
    private final int charPositionInLine;
    
    public AntlrParserError(
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
