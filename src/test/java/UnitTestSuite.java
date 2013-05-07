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
import analyzer.AntlrRoutineProcessorBuilderTest;
import analyzer.AntlrRoutineProcessorTest;
import analyzer.FileBasedMumpsRoutineTest;
import analyzer.FileSystemSourceDistributionTest;
import analyzer.InMemoryMetricStoreTest;
import listener.LineCountListenerTest;
import listener.NonCommentLineCounterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sonar.MumpsCpdMappingTest;
import sonar.SonarMumpsAnalyzerFactoryTest;

@RunWith(Suite.class)
@SuiteClasses({
    AntlrRoutineProcessorTest.class,
    AntlrRoutineProcessorBuilderTest.class,
    FileBasedMumpsRoutineTest.class,
    FileSystemSourceDistributionTest.class,
    InMemoryMetricStoreTest.class,
    LineCountListenerTest.class,
    NonCommentLineCounterTest.class,
    MumpsCpdMappingTest.class,
    SonarMumpsAnalyzerFactoryTest.class
})
public class UnitTestSuite {}
