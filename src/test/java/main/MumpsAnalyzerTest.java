/**
 * Copyright (C) 2013 Chris Barthauer <cbarthauer@gmail.com>
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
package main;

import analyzer.AntlrLexerError;
import analyzer.AntlrRoutineProcessorBuilder;
import analyzer.FileSystemSourceDistribution;
import analyzer.InMemoryLexerErrorListener;
import analyzer.InMemoryMetricStore;
import analyzer.LexerErrorListener;
import analyzer.Metric;
import analyzer.MetricListener;
import analyzer.MetricResult;
import analyzer.MetricStore;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import listener.LineCountListener;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import listener.PrintStreamLexerErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

public class MumpsAnalyzerTest { 
    private final String MUMPS_FILE_PATH 
            = "D:\\mspace\\VistA-FOIA\\Packages\\Toolkit\\Routines\\XINDEX.m";
    private final String VISTA_ACCOUNTS_RECEIVABLE_PATH
            = "D:\\mspace\\VistA-FOIA\\Packages\\Accounts Receivable\\Routines";
    private final String VISTA_INTEGRATED_BILLING_PATH
            = "D:\\mspace\\VistA-FOIA\\Packages\\Integrated Billing\\Routines";
    
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();    
    
    @Test
    public void analyzeSkeleton() {
        final SourceDistribution distribution = context.mock(SourceDistribution.class);
        final RoutineProcessor processor = context.mock(RoutineProcessor.class);
        final MetricStore store = context.mock(MetricStore.class);
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        
        context.checking(new Expectations() {{
            oneOf(distribution).iterator();
            never(processor).process(with(any(MumpsRoutine.class)));
            never(store).append(with(any(Map.class)));
            oneOf(store).clone();
        }});
        
        MetricStore result = analyzer.analyze();        
        assertThat(result.sum(Metric.LOC), equalTo(0));
    }
    
    @Test
    public void analyzeOneRoutine() {
        final File inputFile = new File(MUMPS_FILE_PATH);
        final SourceDistribution distribution = 
                new FileSystemSourceDistribution(inputFile);
        final MetricListener listener = new LineCountListener();
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = builder.setMetricListeners(listener)
                .build();
        final MetricStore store = new InMemoryMetricStore();
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution, 
                processor, 
                store);
        
        MetricStore result = analyzer.analyze();
        assertThat(result.sum(Metric.LOC), equalTo(144));
    }
    
    @Test
    public void analyzeFolderOfRoutines() {
        final File inputFile = new File(VISTA_ACCOUNTS_RECEIVABLE_PATH);
        final SourceDistribution distribution = 
                new FileSystemSourceDistribution(inputFile);
        final MetricListener listener = new LineCountListener();
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = builder.setMetricListeners(listener)
                .build();
        MetricStore store = new InMemoryMetricStore();
        
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution, 
                processor, 
                store);
        
        store = analyzer.analyze();
        assertThat(store.sum(Metric.LOC), equalTo(44620));
        
        Iterator<MetricResult> iterator = store.iterator();
        MetricResult result = iterator.next();
        assertThat(
                VISTA_ACCOUNTS_RECEIVABLE_PATH 
                    + "\\PRCA219P.m", 
                equalTo(result.getPath()));
        assertThat(96.0, equalTo(result.getDouble(Metric.LOC)));
    }
    
    @Test
    public void shouldProcessDistributionWithNoLexerErrors() {
        final File inputFile = new File(VISTA_INTEGRATED_BILLING_PATH);
        final SourceDistribution distribution =
                new FileSystemSourceDistribution(inputFile);
        final LexerErrorListener errorListener = 
                new PrintStreamLexerErrorListener(
                    System.out,
                    new InMemoryLexerErrorListener());
        final AntlrRoutineProcessorBuilder builder =
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = 
                builder.setLexerErrorListener(errorListener)
                    .build();
        final MetricStore store = new InMemoryMetricStore();
        final MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        analyzer.analyze();
        
        List<AntlrLexerError> errors = errorListener.getLexerErrors();
        assertThat(errors.size(), equalTo(0));
    }
}
