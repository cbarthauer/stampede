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
package analyzer;

/**
 * This interface models a single MumpsRoutine.
 * 
 * @author cbarthauer
 */
public interface MumpsRoutine {
    /**
     * Returns the complete source code text of the
     * MumpsRoutine.
     * 
     * @return A String representation of the source code.
     */
    public String asString();
    
    /**
     * Returns a unique identifier for this MumpsRoutine
     * (e.g. the absolute path to the file, etc.).
     * 
     * @return A String representing a unique identifier 
     * for this MumpsRoutine.
     */
    public String identifier();
}
