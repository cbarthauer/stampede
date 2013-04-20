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

import analyzer.MumpsRoutine;
import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;

/**
 * Classes implementing this interface may be registered with an
 * AntlrRoutineProcessor and then notified of lexical errors
 * occurring during MumpsRoutine processing.
 * 
 * @author cbarthauer
 */
public interface LexerErrorListener extends ANTLRErrorListener {
    /**
     * Get a list of lexer errors which occured during MumpsRoutine
     * processing. 
     * 
     * @return List of lexer errors. If no errors, returns an empty
     * list.
     */
    public List<AntlrError> getLexerErrors();
    
    /**
     * Specifies the MumpsRoutine which contains any lexer errors
     * occurring subsequently.
     * 
     * @param routine which contains any subsequent lexer errors.
     */
    public void setMumpsRoutine(MumpsRoutine routine);
}
