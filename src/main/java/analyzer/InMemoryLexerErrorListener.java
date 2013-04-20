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
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * This class records lexer errors for AntlrRoutineProcessor.
 * 
 * @author cbarthauer
 */
public final class InMemoryLexerErrorListener extends BaseErrorListener 
        implements LexerErrorListener {

    private MumpsRoutine routine;
    private final List<AntlrLexerError> errors;
    
    /**
     * Creates InMemoryLexerErrorListener and initializes in-memory
     * data structure.
     */
    public InMemoryLexerErrorListener() {
        this.routine = new NullMumpsRoutine();
        this.errors = new ArrayList<AntlrLexerError>();
    }
    
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {
        
        errors.add(
                new AntlrLexerError(
                    routine.identifier(),
                    msg,
                    line,
                    charPositionInLine));
    }
    
    @Override
    public final List<AntlrLexerError> getLexerErrors() {
        return new ArrayList<AntlrLexerError>(errors);
    }
    
    @Override
    public final void setMumpsRoutine(MumpsRoutine routine) {
        this.routine = routine;
    }
}
