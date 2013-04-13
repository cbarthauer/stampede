package analyzer;

/**
 * This interface models a single MumpsRoutine.
 * 
 * @author cbarthauer
 */
public interface MumpsRoutine {
    /**
     * Returns the complete source code text of the
     * MumpsRoutine.
     * 
     * @return A String representation of the source code.
     */
    public String asString();
    
    /**
     * Returns a unique identifier for this MumpsRoutine
     * (e.g. the absolute path to the file, etc.).
     * 
     * @return A String representing a unique identifier 
     * for this MumpsRoutine.
     */
    public String identifier();
}
