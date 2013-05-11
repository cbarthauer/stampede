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
 * Represents a syntax error in MUMPS source code.
 * 
 * @author cbarthauer
 */
public interface MumpsSyntaxError {
    /**
     * Get the character position of the error.
     * 
     * @return Numeric value of character position
     */
    public int getCharPositionInLine();
    
    /**
     * Get the unique identifier for the MUMPS routine
     * containing this error.
     * 
     * @return Unique identifier
     */
    public String getIdentifier();
    
    /**
     * Get the line number where the error occurs.
     * 
     * @return Numeric value of line number
     */
    public int getLine();
    
    /**
     * Get the text of the error message.
     * 
     * @return Error message
     */
    public String getMessage();
}
