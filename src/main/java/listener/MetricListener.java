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

import analyzer.Metric;

/**
 * This interface models an object which can receive
 * ANTLR parser events via the {@link grammar.MListener}
 * interface. Classes implementing MetricListener are
 * responsible for computing a particular Metric value
 * based on the parser events they receive.
 * 
 * @see analyzer.AntlrRoutineProcessor
 * @author cbarthauer
 */
public interface MetricListener {    
    /**
     * Get the Metric this MetricListener calculates.
     * 
     * @return The Metric.
     */
    public Metric getMetric();
    
    /**
     * Get the value calculated for this MetricListener's
     * Metric.
     * 
     * @return The value calculated for the Metric.
     */
    public int getValue();
    
    /**
     * Clear any accumulated state (i.e. from previous
     * processing) and re-initialize the MetricListener.
     * After calling reset(), the MetricListener should
     * be ready to begin processing again.
     */
    public void reset();
}
