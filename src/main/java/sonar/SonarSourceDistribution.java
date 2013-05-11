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
package sonar;

import analyzer.FileBasedMumpsRoutine;
import analyzer.MumpsRoutine;
import analyzer.SourceDistribution;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.sonar.api.resources.InputFile;

class SonarSourceDistribution implements SourceDistribution {
    private final List<InputFile> inputFiles;

    /**
     * Create a new SonarSourceDistribution backed by the given
     * inputFiles.
     * 
     * @param inputFiles comprising the source distribution.
     */
    SonarSourceDistribution(List<InputFile> inputFiles) {
        this.inputFiles = new ArrayList<InputFile>(inputFiles);
    }

    @Override
    public Iterator<MumpsRoutine> iterator() {
        List<MumpsRoutine> routines = new ArrayList<MumpsRoutine>();
        
        for(InputFile inputFile : inputFiles) {
            routines.add(new FileBasedMumpsRoutine(inputFile.getFile()));
        }
        
        return routines.iterator();
    }
    
}
