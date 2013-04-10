package analyzer;

import grammar.MLexer;
import grammar.MParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public final class AntlrRoutineProcessor implements RoutineProcessor {

    private List<MetricListener> listeners;
    
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
