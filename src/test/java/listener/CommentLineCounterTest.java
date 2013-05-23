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
package listener;

import analyzer.Metric;
import analyzer.MumpsRoutine;
import analyzer.StringBasedMumpsRoutine;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static analyzer.AntlrRoutineProcessorFactory.*;
import analyzer.RoutineProcessor;
import org.junit.Before;

public class CommentLineCounterTest {
    
    private RoutineProcessor processor;
    
    @Before
    public void setup() {
        processor = getRoutineProcessor(new CommentLineCounter());
    }
    
    @Test
    public void shouldCountCommentLinesWithBlockLevelIndicators() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                " ... ; Comment with block level indicators.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));        
    }
    
    @Test
    public void shouldIgnoreLineWithCommand() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                " Q ; Has command.",
                " ; Just a comment.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));
    }
    
    @Test
    public void shouldIgnoreLineWithEntryLabel() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.",
                " ; Just a comment.");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));
    }
    
    @Test
    public void shouldResetAfterEachRoutine() {
        final MumpsRoutine routine1 = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.",
                " ; Comment only.");
        Map<String, Map<Metric, Integer>> results1 = processor.process(routine1);
        assertThat(results1.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(1));

        final MumpsRoutine routine2 = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; Has entry label.");
        Map<String, Map<Metric, Integer>> results2 = processor.process(routine2);
        assertThat(results2.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(0));
    }
    
    @Test
    public void shouldReturnZeroForEmptyRoutine() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "");
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.COMMENT_LINES), equalTo(0));
    }

}
