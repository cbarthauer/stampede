package analyzer;

import grammar.MLexer;
import grammar.MParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * A RoutineProcessor implemented using the ANTLR parser generator.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessor implements RoutineProcessor {

    private List<MetricListener> listeners;
    
    /**
     * Creates an AntlrRoutineProcessor which notifies each of the given
     * {@link analyzer.MetricListener} objects appropriately as it
     * processes each {@link analyzer.MumpsRoutine}.
     * 
     * @param listeners The listeners which the AntlrRoutineProcessor
     * will notify with parse events.
     */
    public AntlrRoutineProcessor(MetricListener... listeners) {
        this.listeners = Arrays.asList(listeners);
    }

    @Override
    public Map<String, Map<Metric, Integer>> process(MumpsRoutine routine) {
        ANTLRInputStream input = new ANTLRInputStream(routine.asString());
        MLexer lexer = new MLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MParser parser = new MParser(tokens);
        
        for(MetricListener listener : listeners) {
            parser.addParseListener(listener.asMListener());
        }
        
        parser.routine();
        
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        
        for(MetricListener listener : listeners) {
            metricMap.put(listener.getMetric(), listener.getValue());
        }
        
        Map<String, Map<Metric, Integer>> resultMap = 
                new HashMap<String, Map<Metric, Integer>>();
        resultMap.put(routine.identifier(), metricMap);
        
        resetMetricListeners();
        return resultMap;
    }

    private void resetMetricListeners() {
        for(MetricListener listener : listeners) {
            listener.reset();
        }
    }
    
}
