package analyzer;

/**
 *
 * @author cbarthauer
 */
public final class StringBasedMumpsRoutine implements MumpsRoutine {
    private final String identifier;
    private final String source;

    public StringBasedMumpsRoutine(String identifier, String... sourceLines) {
        this.identifier = identifier;
        this.source = join(sourceLines);
    }

    @Override
    public final String asString() {
        return source;
    }

    @Override
    public final String identifier() {
        return identifier;
    }        

    private static String join(String[] sourceLines) {
        final StringBuffer buffer = new StringBuffer("");
        
        for(String line : sourceLines) {
            buffer.append(line);
            
            if(!line.endsWith("\n")) {
                buffer.append("\n");
            }
        }
        
        return buffer.toString();
    }
}
