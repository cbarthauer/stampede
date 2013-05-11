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
package analyzer;

/**
 *
 * @author cbarthauer
 */
public final class StringBasedMumpsRoutine implements MumpsRoutine {
    private final String identifier;
    private final String source;

    public StringBasedMumpsRoutine(String identifier, String... sourceLines) {
        this.identifier = identifier;
        this.source = join(sourceLines);
    }

    @Override
    public final String asString() {
        return source;
    }

    @Override
    public final String identifier() {
        return identifier;
    }        

    private static String join(String[] sourceLines) {
        final StringBuffer buffer = new StringBuffer("");
        
        for(String line : sourceLines) {
            buffer.append(line);
            
            if(!line.endsWith("\n")) {
                buffer.append("\n");
            }
        }
        
        return buffer.toString();
    }
}
