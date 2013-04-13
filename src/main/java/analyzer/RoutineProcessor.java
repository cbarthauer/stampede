package analyzer;

import java.util.Map;

/**
 * This interface models an object which can process the source code
 * comprising a MUMPS routine.
 * 
 * @author cbarthauer
 */
public interface RoutineProcessor {
    /**
     * Process the given MumpsRoutine.
     * 
     * @param routine to process.
     * @return A data structure containing the results.
     */
    public Map<String, Map<Metric, Integer>> process(MumpsRoutine routine);
}
