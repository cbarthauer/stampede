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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;

import antlr.AntlrRoutineProcessorBuilder;
import antlr.AntlrRoutineProcessor;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author cbarthauer
 */
public class AntlrRoutineProcessorBuilderTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
        
    @Test
    public void shouldBuildNoOpAntlrRoutineProcessor() {
        final MumpsRoutine routine = context.mock(MumpsRoutine.class);
        AntlrRoutineProcessorBuilder builder = new AntlrRoutineProcessorBuilder();
        AntlrRoutineProcessor processor = builder.build();
        
        context.checking(new Expectations() {{
            oneOf(routine).asString();
            will(returnValue("HELLO ; This is a comment.\n"));
            oneOf(routine).identifier();
            will(returnValue("HELLO.m"));
        }});
        
        Map<String, Map<Metric, Integer>> results = processor.process(routine);
        assertThat(results.size(), equalTo(1));
        assertThat(results.get("HELLO.m").isEmpty(), equalTo(true));
    }
}
