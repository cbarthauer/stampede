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
import analyzer.RoutineProcessor;
import analyzer.StringBasedMumpsRoutine;
import antlr.AntlrRoutineProcessorBuilder;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author cbarthauer
 */
public final class NonCommentLineCounterTest {

    @Test
    public void shouldCountMultipleCommandLinesOnce() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; This is an NCLOC.",
                " W \"HELLO!\" Q ; This is an NCLOC.",
                " ; This is not an NCLOC.");
        final RoutineProcessor processor = routineProcessor();
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.NCLOC), equalTo(2));
    }

    @Test
    public void shouldCountMultipleIdentifierLinesOnce() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO N LVAR,RVAR ; This is an NCLOC.",
                " ; This is not an NCLOC.");
        final RoutineProcessor processor = routineProcessor();
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.NCLOC), equalTo(1));
    }

    @Test
    public void shouldIgnoreBlockLevelCommentOnlyLines() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; This is an NCLOC.",
                " ... ; This not an NCLOC.");
        final RoutineProcessor processor = routineProcessor();
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.NCLOC), equalTo(1));
    }

    @Test
    public void shouldIgnoreCommentOnlyLines() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; This is an NCLOC.",
                " ; This not an NCLOC.");
        final RoutineProcessor processor = routineProcessor();
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.NCLOC), equalTo(1));
    }

    @Test
    public void shouldResetAfterEachRoutine() {
        final MumpsRoutine routine1 = new StringBasedMumpsRoutine(
                "HELLO.m",
                "HELLO ; This is an NCLOC.",
                " ; This not an NCLOC.");
        RoutineProcessor processor = routineProcessor();
        Map<String, Map<Metric, Integer>> results1 = processor.process(routine1);
        assertThat(results1.get("HELLO.m").get(Metric.NCLOC), equalTo(1));

        final MumpsRoutine routine2 = new StringBasedMumpsRoutine(
                "HELLO.m",
                " ; This not an NCLOC.");
        Map<String, Map<Metric, Integer>> results2 = processor.process(routine2);
        assertThat(results2.get("HELLO.m").get(Metric.NCLOC), equalTo(0));
    }

    @Test
    public void shouldReturnZeroForEmptyRoutine() {
        final MumpsRoutine routine = new StringBasedMumpsRoutine(
                "HELLO.m",
                "");
        final RoutineProcessor processor = routineProcessor();
        final Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.get("HELLO.m").get(Metric.NCLOC), equalTo(0));
    }

    private RoutineProcessor routineProcessor() {
        final AntlrMetricListener listener = new NonCommentLineCounter();
        final AntlrRoutineProcessorBuilder builder =
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor =
                builder.setAntlrMetricListeners(listener)
                .build();
        return processor;
    }
}
