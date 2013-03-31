package main;

import analyzer.Metric;
import analyzer.MetricResultSet;
import analyzer.MetricStore;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import java.util.Iterator;
import java.util.Map;

public final class MumpsAnalyzer {
    private final SourceDistribution distribution;
    private final RoutineProcessor processor;
    private final MetricStore store;

    public MumpsAnalyzer(
            SourceDistribution distribution, 
            RoutineProcessor processor, 
            MetricStore store) {
        
        this.distribution = distribution;
        this.processor = processor;
        this.store = store;
    }

    public final MetricStore analyze() {
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        
        while(iterator.hasNext()) {
            MumpsRoutine routine = iterator.next();
            Map<String, Map<Metric, Integer>> resultSet = processor.process(routine);
            store.write(resultSet);
        }
        
        return store.clone();
    }
    
}
