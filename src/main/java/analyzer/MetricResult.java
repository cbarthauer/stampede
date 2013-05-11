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
package analyzer;

/**
 * This interface models a set of Metric results for a
 * MUMPS source code file located at a particular path
 * in the file system.
 * 
 * @author cbarthauer
 */
public interface MetricResult {
    /**
     * Get the value of the give metric as a double.
     * 
     * @param metric of interest.
     * @return The value associated with the given Metric.
     */
    public double getDouble(Metric metric);
    
    /**
     * Get the absolute path to the MUMPS source code file
     * whose results this object represents.
     * 
     * @return A String representation of the absolute 
     * file path.
     */
    public String getPath();
}
