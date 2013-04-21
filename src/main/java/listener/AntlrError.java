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

/**
 * This class represents a lexer or parser error occurring while processing
 * MUMPS source code. Instances of this class are immutable.
 * 
 * @author cbarthauer
 */
public final class AntlrError {
    private final String identifier;
    private final String message;
    private final int line;
    private final int charPositionInLine;
    
    /**
     * Create a new ANTLR error.
     * 
     * @param identifier Uniquely identifies the containing
     *     MUMPS routine
     * @param message ANTLR error message
     * @param line Line number where error occurred
     * @param charPositionInLine Character position in line where
     *     error occurred
     */
    public AntlrError(
            String identifier,
            String message,
            int line,
            int charPositionInLine) {
        this.identifier = identifier;
        this.message = message;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }
    
    /**
     * Get the character position of the error.
     * 
     * @return Numeric value of character position
     */
    public final int getCharPositionInLine() {
        return charPositionInLine;
    }
    
    /**
     * Get the unique identifier for the MUMPS routine
     * containing this error.
     * 
     * @return Unique identifier
     */
    public final String getIdentifier() {
        return identifier;
    }
    
    /**
     * Get the line number where the error occurs.
     * 
     * @return Numeric value of line number
     */
    public final int getLine() {
        return line;
    }
    
    /**
     * Get the text of the error message.
     * 
     * @return Error message
     */
    public final String getMessage() {
        return message;
    }

    @Override
    public final String toString() {
        return identifier 
                + "\t" + line 
                + "\t" + charPositionInLine 
                + "\t" + message;
    }
}
