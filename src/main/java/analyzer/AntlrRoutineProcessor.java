/**
 * Copyright (C) 2013 Chris Barthauer <cbarthauer@gmail.com>
 *
 * This file is part of MumpsAnalyzer.
 *
 * MumpsAnalyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MumpsAnalyzer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MumpsAnalyzer.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
package analyzer;

import grammar.MLexer;
import grammar.MParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * A RoutineProcessor implemented using the ANTLR parser generator.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessor implements RoutineProcessor {

    private List<MetricListener> metricListeners;
    private final ANTLRErrorListener lexerErrorListener;
    
    /**
     * Creates an AntlrRoutineProcessor which notifies each of the given
     * {@link analyzer.MetricListener} objects appropriately as it
     * processes each {@link analyzer.MumpsRoutine}.
     * 
     * @param metricListeners The listeners which the AntlrRoutineProcessor
     * will notify with parse events.
     */
    public AntlrRoutineProcessor(MetricListener... metricListeners) {
        this(new BaseErrorListener(), metricListeners);
    }
    
    public AntlrRoutineProcessor(
            ANTLRErrorListener lexerErrorListener, 
            MetricListener... metricListeners) {
        
        this.lexerErrorListener = lexerErrorListener;
        this.metricListeners = Arrays.asList(metricListeners);
    }

    @Override
    public Map<String, Map<Metric, Integer>> process(MumpsRoutine routine) {
        ANTLRInputStream input = new ANTLRInputStream(routine.asString());
        MLexer lexer = new MLexer(input);
        lexer.addErrorListener(lexerErrorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MParser parser = new MParser(tokens);
        
        for(MetricListener listener : metricListeners) {
            parser.addParseListener(listener.asMListener());
        }
        
        parser.routine();
        
        Map<Metric, Integer> metricMap = new HashMap<Metric, Integer>();
        
        for(MetricListener listener : metricListeners) {
            metricMap.put(listener.getMetric(), listener.getValue());
        }
        
        Map<String, Map<Metric, Integer>> resultMap = 
                new HashMap<String, Map<Metric, Integer>>();
        resultMap.put(routine.identifier(), metricMap);
        
        resetMetricListeners();
        return resultMap;
    }

    private void resetMetricListeners() {
        for(MetricListener listener : metricListeners) {
            listener.reset();
        }
    }
}
