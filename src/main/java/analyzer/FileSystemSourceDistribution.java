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

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class models a collection of MUMPS routines backed by
 * the file system (i.e., MUMPS source code stored in text files).
 * 
 * @author cbarthauer
 */
public final class FileSystemSourceDistribution implements SourceDistribution {
    private final File file;
    private final String mumpsFileExtension = ".m";
    private final List<MumpsRoutine> routineList;    

    /**
     * Create a FileBasedMumpsRoutine backed by the given file. The file may be
     * either a single file or a directory. Directories will be traversed
     * recursively in search of MUMPS source code files (i.e. files ending with
     * a .m extension).
     * 
     * @param file or directory containing the source code for one or more MUMPS 
     * routines.
     */
    public FileSystemSourceDistribution(File file) {
        this.file = file;
        this.routineList = new ArrayList<MumpsRoutine>();
    }

    @Override
    public final Iterator<MumpsRoutine> iterator() {
        traverse(file);
        return new ArrayList<MumpsRoutine>(routineList).iterator();
    }

    private void traverse(File file) {
        if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                traverse(f);
            }
        }
        else {
            if(file.getPath().endsWith(mumpsFileExtension)) {
                routineList.add(new FileBasedMumpsRoutine(file));
            }
        }
    }    
}
