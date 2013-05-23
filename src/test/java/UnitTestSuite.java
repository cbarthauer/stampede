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
import analyzer.AntlrRoutineProcessorBuilderTest;
import analyzer.AntlrRoutineProcessorTest;
import analyzer.FileBasedMumpsRoutineTest;
import analyzer.FileSystemSourceDistributionTest;
import analyzer.InMemoryMetricStoreTest;
import analyzer.MapBasedMetricResultTest;
import listener.CommentLineCounterTest;
import listener.LineCountListenerTest;
import listener.NonCommentLineCounterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sonar.MumpsCpdMappingTest;
import sonar.MumpsSensorTest;
import sonar.PhysicalLinesAggregateViolationHandlerTest;
import sonar.SonarMumpsAnalyzerFactoryTest;
import sonar.StampedeMetricHandlerTest;
import sonar.SyntaxErrorViolationHandlerTest;

@RunWith(Suite.class)
@SuiteClasses({
    AntlrRoutineProcessorTest.class,
    AntlrRoutineProcessorBuilderTest.class,
    CommentLineCounterTest.class,
    FileBasedMumpsRoutineTest.class,
    FileSystemSourceDistributionTest.class,
    InMemoryMetricStoreTest.class,
    LineCountListenerTest.class,
    MapBasedMetricResultTest.class,
    MumpsCpdMappingTest.class,
    MumpsSensorTest.class,
    NonCommentLineCounterTest.class,
    PhysicalLinesAggregateViolationHandlerTest.class,
    SonarMumpsAnalyzerFactoryTest.class,
    StampedeMetricHandlerTest.class,
    SyntaxErrorViolationHandlerTest.class
})
public class UnitTestSuite {}
