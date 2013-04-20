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
package sonar;

import analyzer.AntlrRoutineProcessorBuilder;
import analyzer.InMemoryLexerErrorListener;
import analyzer.InMemoryMetricStore;
import analyzer.LexerErrorListener;
import analyzer.MetricListener;
import analyzer.MetricStore;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import listener.LineCountListener;
import listener.PrintStreamLexerErrorListener;
import main.MumpsAnalyzer;
import org.sonar.api.resources.InputFile;

/**
 * A factory for creating MumpsAnalyzer objects suitable for use within
 * the Sonar MumpsSensor class.
 * 
 * @author cbarthauer
 */
final class SonarMumpsAnalyzerFactory {

    /**
     * Creates a MumpsAnalyzer for the give inputFiles. The MumpsAnalyzer
     * is suitable for use within the Sonar MumpsSensor.
     * 
     * @param inputFiles List of MUMPS source files from Sonar.
     * @return A properly initialized MumpsAnalyzer.
     */
    static MumpsAnalyzer getMumpsAnalyzer(List<InputFile> inputFiles) {
        final SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        final MetricListener metricListener = new LineCountListener();
        final LexerErrorListener lexerListener = getLexerErrorListener();
        final AntlrRoutineProcessorBuilder builder = 
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor processor = builder.setMetricListeners(metricListener)
                .setLexerErrorListener(lexerListener)
                .build();
        MetricStore store = new InMemoryMetricStore();
        MumpsAnalyzer analyzer = new MumpsAnalyzer(
                distribution,
                processor,
                store);
        return analyzer;
    }
    
    private static LexerErrorListener getLexerErrorListener() {
        PrintStream out = System.out;
        
        try {
            out = new PrintStream(new java.io.File("lexer_errors.log"));
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to create lexer_errors.log; redirecting lexer errors to System.out.");
        }
        
        return new PrintStreamLexerErrorListener(
                out, 
                new InMemoryLexerErrorListener());
    }
    
    private SonarMumpsAnalyzerFactory() {
        //Hide utility class constructor.
    }   
    
}