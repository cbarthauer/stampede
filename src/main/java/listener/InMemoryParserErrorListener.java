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
package listener;

import analyzer.MumpsSyntaxError;
import analyzer.MumpsRoutine;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * This class records parsing errors for AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class InMemoryParserErrorListener extends BaseErrorListener
        implements ParserErrorListener {
    
    private MumpsRoutine routine;
    private final List<MumpsSyntaxError> errors;

    /**
     * Creates InMemoryParserErrorListener and initializes in-memory
     * data structure.
     */
    public InMemoryParserErrorListener() {
        this.routine = new NullMumpsRoutine();
        this.errors = new ArrayList<MumpsSyntaxError>();
    }
    
    @Override
    public final void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {
        
        errors.add(
                new AntlrError(
                    routine.identifier(),
                    msg,
                    line,
                    charPositionInLine));
    }
    
    @Override
    public final List<MumpsSyntaxError> getParserErrors() {
        return new ArrayList<MumpsSyntaxError>(errors);
    }

    @Override
    public void setMumpsRoutine(MumpsRoutine routine) {
        this.routine = routine;
    }
    
}
