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

import antlr.AntlrRoutineProcessorBuilder;
import listener.LexerErrorListener;
import listener.InMemoryLexerErrorListener;
import java.util.List;
import java.util.Map;
import listener.AntlrMetricListener;
import listener.InMemoryParserErrorListener;
import listener.LineCountListener;
import listener.ParserErrorListener;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AntlrRoutineProcessorTest {
    @Test
    public void shouldCountLines() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m", 
                "HELLO ; This is a comment.\n");
        final AntlrMetricListener listener = new LineCountListener();        
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = builder.setAntlrMetricListeners(listener)
                .build();
        Map<String, Map<Metric, Integer>> result = processor.process(routine);
        assertThat(result.get("HELLO.m").get(Metric.LOC), equalTo(1));
    }
    
    @Test
    public void shouldLogLexerErrors() {
        final String unicodeSigmaCharacter = "\u03A3";
        final String routineIdentifier = "HELLO";
        MumpsRoutine routine = new StringBasedMumpsRoutine(
                routineIdentifier, "HELLO " + unicodeSigmaCharacter + "\n");
        LexerErrorListener errorListener = 
                new InMemoryLexerErrorListener();
        AntlrRoutineProcessorBuilder builder = new AntlrRoutineProcessorBuilder();
        RoutineProcessor processor = builder.setLexerErrorListener(errorListener)
                .build();
        
        processor.process(routine); 
        List<MumpsSyntaxError> errors = processor.syntaxErrors();
        
        assertThat(errors.size(), greaterThan(0));
        assertThat(
                errors.get(0).getMessage(), 
                equalTo("token recognition error at: '" 
                    + unicodeSigmaCharacter + "'"));
        assertThat(
                errors.get(0).getLine(),
                equalTo(1));
        assertThat(
                errors.get(0).getCharPositionInLine(),
                equalTo(6));
        assertThat(
                errors.get(0).getIdentifier(),
                equalTo(routineIdentifier));
    }
        
    @Test
    public void shouldLogParserErrors() {
        //Parser error: Double quote after S command.
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO",
                "HELLO\n"
                    + " SET \"\n");
        final ParserErrorListener errorListener = new InMemoryParserErrorListener();
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = 
                builder.setParserErrorListener(errorListener)
                    .build();
        processor.process(routine);
        List<MumpsSyntaxError> errors = processor.syntaxErrors();
        assertThat(errors.size(), greaterThan(0));
        assertThat(
                errors.get(0).getMessage(),
                equalTo("no viable alternative at input ' \"'"));
        assertThat(
                errors.get(0).getLine(),
                equalTo(2));
        assertThat(
                errors.get(0).getCharPositionInLine(),
                equalTo(5));
        assertThat(
                errors.get(0).getIdentifier(),
                equalTo("HELLO"));
    }
}
