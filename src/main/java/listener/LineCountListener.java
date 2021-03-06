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
import grammar.MBaseListener;
import grammar.MParser;

/**
 * This class counts lines of code for MUMPS routines.
 * 
 * @author cbarthauer
 */
public final class LineCountListener 
        extends MBaseListener 
        implements AntlrMetricListener {
    
    private int lineCount;

    /**
     * Create LineCountListener with initial line count of zero.
     */
    public LineCountListener() {
        lineCount = 0;
    }
    
    @Override
    public final void enterLevelLine(MParser.LevelLineContext ctx) { 
        lineCount++;
    }
    
    @Override
    public final Metric getMetric() {
        return Metric.LOC;
    }
    
    @Override
    public final int getValue() {
        return lineCount;
    }

    @Override
    public final void reset() {
        lineCount = 0;
    }
}
