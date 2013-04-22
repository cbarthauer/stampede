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
package main;

import analyzer.Metric;
import analyzer.MetricResult;
import analyzer.MetricStore;
import analyzer.MumpsRoutine;
import analyzer.RoutineProcessor;
import analyzer.SourceDistribution;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import analyzer.MumpsSyntaxError;

/**
 * This class analyzes a collection of MUMPS routines, modeled by
 * a {@link analyzer.SourceDistribution} object. Analysis of each 
 * individual routine is delegated to a {@link analyzer.RoutineProcessor}
 * object, and the results are stored in a {@link analyzer.MetricStore} 
 * object.
 * 
 * @author cbarthauer
 */
public final class MumpsAnalyzer {
    private final SourceDistribution distribution;
    private final RoutineProcessor processor;
    private final MetricStore store;

    /**
     * Creates a new MumpsAnalyzer. All parameters are required
     * and are assumed to be properly initialized.
     * 
     * @param distribution The collection of MUMPS routines
     * to analyze.
     * 
     * @param processor The processor used to perform the
     * analysis of each routine.
     * 
     * @param store The repository where the results are
     * stored.
     */
    public MumpsAnalyzer(
            SourceDistribution distribution, 
            RoutineProcessor processor, 
            MetricStore store) {
        
        this.distribution = distribution;
        this.processor = processor;
        this.store = store;
    }

    /**
     * Analyze the SourceDistribution using the RoutineProcessor.
     */
    public final void analyze() {
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        
        while(iterator.hasNext()) {
            MumpsRoutine routine = iterator.next();
            Map<String, Map<Metric, Integer>> resultSet = processor.process(routine);
            store.append(resultSet);
        }
    }
    
    /**
     * Obtain the metric results from the analysis.
     * 
     * @return List of metric results or an empty list if there are no
     *   results.
     */
    public final List<MetricResult> metricResults() {
        return store.metricResults();
    }
    
    /**
     * Calculate the sum of values for the given metric.
     * 
     * @param metric to sum.
     * @return An int representing the total for the given
     *   metric.
     */
    public final int sum(Metric metric) {
        return store.sum(metric);
    }    

    /**
     * Obtain a list of syntax errors which were found during
     * the analysis.
     * 
     * @return List of syntax errors or an empty list if there are
     *   no such errors.
     */
    public final List<MumpsSyntaxError> syntaxErrors() {
        return processor.syntaxErrors();
    }
}
