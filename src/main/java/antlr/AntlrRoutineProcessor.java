/**
 * Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
 *
 * This file is part of STAMPEDE.
 *
 * STAMPEDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * STAMPEDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
package antlr;

import analyzer.Metric;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import listener.MetricListener;
import listener.LexerErrorListener;
import grammar.MLexer;
import grammar.MParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import analyzer.MumpsSyntaxError;
import listener.AntlrMetricListener;
import listener.ParserErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * A RoutineProcessor implemented using the ANTLR parser generator.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessor implements RoutineProcessor {

    private final List<AntlrMetricListener> metricListeners;
    private final LexerErrorListener lexerErrorListener;
    private final ParserErrorListener parserErrorListener;
    
    /**
     * Creates an AntlrRoutineProcessor which notifies each of the given
     * {@link analyzer.MetricListener} objects appropriately as it
     * processes each {@link analyzer.MumpsRoutine}.
     * 
     * @param lexerErrorListener The listener to be notified of lexer errors.
     * @param parserErrorListener The listener to be notified of parser errors.
     * @param metricListeners The listeners which the AntlrRoutineProcessor
     *     will notify with parse events.
     */    
    AntlrRoutineProcessor(
            LexerErrorListener lexerErrorListener, 
            ParserErrorListener parserErrorListener,
            AntlrMetricListener... metricListeners) {
        
        this.parserErrorListener = parserErrorListener;
        this.lexerErrorListener = lexerErrorListener;
        this.metricListeners = Arrays.asList(metricListeners);
    }

    @Override
    public final Map<String, Map<Metric, Integer>> process(MumpsRoutine routine) {
        ANTLRInputStream input = new ANTLRInputStream(routine.asString());
        MLexer lexer = new MLexer(input);
        lexerErrorListener.setMumpsRoutine(routine);
        lexer.addErrorListener(lexerErrorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MParser parser = new MParser(tokens);
        parserErrorListener.setMumpsRoutine(routine);
        parser.addErrorListener(parserErrorListener);
        
        for(AntlrMetricListener listener : metricListeners) {
            parser.addParseListener(listener);
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

    @Override
    public List<MumpsSyntaxError> syntaxErrors() {
        List<MumpsSyntaxError> result = new ArrayList<MumpsSyntaxError>();
        result.addAll(lexerErrorListener.getLexerErrors());
        result.addAll(parserErrorListener.getParserErrors());
        return result;
    }
}
