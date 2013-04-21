/**
 * Copyright (C) 2013 Chris Barthauer <mumpsanalyzer@gmail.com>
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
package antlr;

import analyzer.MumpsRoutine;
import listener.AntlrError;
import listener.MetricListener;
import listener.LexerErrorListener;
import java.util.ArrayList;
import java.util.List;
import listener.ParserErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;

/**
 * This class builds instances of AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessorBuilder {
    private LexerErrorListener lexerErrorListener;
    private MetricListener[] metricListeners;
    private ParserErrorListener parserErrorListener;

    /**
     * Creates a builder instance with no MetricListeners
     * and a no-op LexerErrorListener. 
     */
    public AntlrRoutineProcessorBuilder() {
        lexerErrorListener = new NullLexerErrorListener();
        metricListeners = new MetricListener[]{};
        parserErrorListener = new NullParserErrorListener();
    }
    
    /**
     * Create an AntlrRoutineProcessor using the components specified
     * by the setXXX(...) methods.
     * 
     * @return An AntlrRoutineProcessor properly initialized.
     */
    public final AntlrRoutineProcessor build() {
        return new AntlrRoutineProcessor(
                lexerErrorListener,
                parserErrorListener,
                metricListeners);
    }
    
    /**
     * Register the given LexerErrorListener with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param lexerErrorListener to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setLexerErrorListener(
            LexerErrorListener lexerErrorListener) {
        this.lexerErrorListener = lexerErrorListener;
        return this;
    }

    /**
     * Register the given MetricListeners with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param metricListeners to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setMetricListeners(
            MetricListener... metricListeners) {
        this.metricListeners = metricListeners;
        return this;
    }

    /**
     * Register the given ParserErrorListener with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param parserErrorListener to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setParserErrorListener(
            ParserErrorListener parserErrorListener) {
        this.parserErrorListener = parserErrorListener;
        return this;
    }
    
    private final class NullLexerErrorListener extends BaseErrorListener 
            implements LexerErrorListener {

        @Override
        public final List<AntlrError> getLexerErrors() {
            return new ArrayList<AntlrError>();
        }

        @Override
        public final void setMumpsRoutine(MumpsRoutine routine) {
            //No-op;
        }
        
    }
    
    private final class NullParserErrorListener extends BaseErrorListener
            implements ParserErrorListener {

        @Override
        public final List<AntlrError> getParserErrors() {
            return new ArrayList<AntlrError>();
        }

        @Override
        public final void setMumpsRoutine(MumpsRoutine routine) {
            //No-op.
        }
        
    }
}
