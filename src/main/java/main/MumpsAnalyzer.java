package main;

import analyzer.Metric;
import analyzer.MetricStore;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import java.util.Iterator;
import java.util.Map;

/**
 * This class analyzes a collection of MUMPS routines, modeled by
 * a {@link analyzer.SourceDistribution} object. Analysis of each 
 * individual routine is delegated to a {@link analyzer.RoutineProcessor}
 * object, and the results are stored in a {@link analyzer.MetricStore} 
 * object.
 * 
 * @author cbarthauer
 */
public final class MumpsAnalyzer {
    private final SourceDistribution distribution;
    private final RoutineProcessor processor;
    private final MetricStore store;

    /**
     * Creates a new MumpsAnalyzer. All parameters are required
     * and are assumed to be properly initialized.
     * 
     * @param distribution The collection of MUMPS routines
     * to analyze.
     * 
     * @param processor The processor used to perform the
     * analysis of each routine.
     * 
     * @param store The repository where the results are
     * stored.
     */
    public MumpsAnalyzer(
            SourceDistribution distribution, 
            RoutineProcessor processor, 
            MetricStore store) {
        
        this.distribution = distribution;
        this.processor = processor;
        this.store = store;
    }

    /**
     * Analyze the SourceDistribution using the RoutineProcessor.
     * 
     * @return MetricStore object containing the results of
     * the analysis.
     */
    public final MetricStore analyze() {
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        
        while(iterator.hasNext()) {
            MumpsRoutine routine = iterator.next();
            Map<String, Map<Metric, Integer>> resultSet = processor.process(routine);
            store.append(resultSet);
        }
        
        return store.clone();
    }
    
}
