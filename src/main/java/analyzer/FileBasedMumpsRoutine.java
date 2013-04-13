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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class models a MumpsRoutine backed by a source code
 * file.
 * 
 * @author cbarthauer
 */
public final class FileBasedMumpsRoutine implements MumpsRoutine {
    private final File file;
    private final int eof = -1;

    /**
     * Create a FileBasedMumpsRoutine backed by the given file.
     * 
     * @param file containing the source code for a MUMPS 
     * routine.
     */
    public FileBasedMumpsRoutine(File file) {
        this.file = file;
    }

    @Override
    public final String asString() {
        StringBuilder builder = new StringBuilder("");
        
        try {
            FileReader fr = new FileReader(file);
            int currentCharacter = eof;      
            
            while((currentCharacter = fr.read()) != eof) {
                builder.append(new Character((char) currentCharacter));
            }
        } catch (IOException ex) {
            Logger.getLogger(FileBasedMumpsRoutine.class.getName())
                    .log(Level.SEVERE, 
                        "Error reading file: " + file.getPath(), 
                        ex);
        }
        
        return builder.toString();
    }    

    @Override
    public final String identifier() {
        return file.getPath();
    }
}
