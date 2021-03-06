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

import java.util.List;
import java.util.Map;

/**
 * This interface models an object which can process the source code
 * comprising a MUMPS routine.
 * 
 * @author cbarthauer
 */
public interface RoutineProcessor {
    /**
     * Process the given MumpsRoutine.
     * 
     * @param routine to process.
     * @return A data structure containing the results.
     */
    public Map<String, Map<Metric, Integer>> process(MumpsRoutine routine);
    
    /**
     * Obtain a list of syntax errors which occurred within the processed
     * MumpsRoutine.
     * 
     * @return List of syntax errors or an empty list if there were no
     *   such errors.
     */
    public List<MumpsSyntaxError> syntaxErrors();
}
