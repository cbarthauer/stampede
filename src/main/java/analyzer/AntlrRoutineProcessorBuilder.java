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
package analyzer;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;

/**
 * This class builds instances of AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class AntlrRoutineProcessorBuilder {
    private LexerErrorListener errorListener;
    private MetricListener[] metricListeners;

    /**
     * Creates a builder instance with no MetricListeners
     * and a no-op LexerErrorListener. 
     */
    public AntlrRoutineProcessorBuilder() {
        errorListener = new NullLexerErrorListener();
        metricListeners = new MetricListener[]{};
    }
    
    /**
     * Create an AntlrRoutineProcessor using the components specified
     * by the setXXX(...) methods.
     * 
     * @return An AntlrRoutineProcessor properly initialized.
     */
    public final AntlrRoutineProcessor build() {
        return new AntlrRoutineProcessor(
                errorListener,
                metricListeners);
    }
    
    /**
     * Register the given LexerErrorListener with the AntlrRoutineProcessor
     * to be built.
     * 
     * @param errorListener to register
     * @return This builder
     */
    public final AntlrRoutineProcessorBuilder setLexerErrorListener(
            LexerErrorListener errorListener) {
        this.errorListener = errorListener;
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
    
    private final class NullLexerErrorListener extends BaseErrorListener 
            implements LexerErrorListener {

        @Override
        public final List<AntlrLexerError> getLexerErrors() {
            return new ArrayList<AntlrLexerError>();
        }

        @Override
        public final void setMumpsRoutine(MumpsRoutine routine) {
            //No-op;
        }
        
    }
}
