package analyzer;

import java.util.Iterator;

/**
 * This interface models a collection of MUMPS source code
 * files.
 * 
 * @author cbarthauer
 */
public interface SourceDistribution {
    /**
     * Returns an iterator suitable for enumerating the
     * MumpsRoutines comprising this SourceDistribution.
     * 
     * @return An iterator
     */
    public Iterator<MumpsRoutine> iterator();    
}
