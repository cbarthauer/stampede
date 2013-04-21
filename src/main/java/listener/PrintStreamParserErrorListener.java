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
import java.io.PrintStream;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Notified of parser errors by AntlrRoutineProcessor. Writes errors to
 * a designated PrintStream.
 * 
 * @author cbarthauer
 */
public final class PrintStreamParserErrorListener extends BaseErrorListener 
    implements ParserErrorListener {

    private PrintStream out;
    private InMemoryParserErrorListener wrappedListener;

    /**
     * Constructs a PrintStreamParserErrorListener which will write parser
     * errors to the given PrintStream.
     * 
     * @param out PrintStream used to log Parser errors.
     * @param wrappedListener All other method calls delegated to wrapped 
     *      InMemoryParserErrorListener
     */
    public PrintStreamParserErrorListener(
            PrintStream out,
            InMemoryParserErrorListener wrappedListener) {
        this.out = out;
        this.wrappedListener = wrappedListener;
    }

    @Override
    public final void syntaxError(
            Recognizer<?, ?> recognizer, 
            Object offendingSymbol, 
            int line, 
            int charPositionInLine, 
            String msg, 
            RecognitionException e) {

        wrappedListener.syntaxError(
                recognizer, 
                offendingSymbol, 
                line, 
                charPositionInLine, 
                msg, 
                e);
        List<AntlrError> errors = wrappedListener.getParserErrors();
        out.println(errors.get(errors.size() - 1));
    }

    @Override
    public final List<AntlrError> getParserErrors() {
        return wrappedListener.getParserErrors();
    }

    @Override
    public final void setMumpsRoutine(MumpsRoutine routine) {
        wrappedListener.setMumpsRoutine(routine);
    }        
}

