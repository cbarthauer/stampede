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

import analyzer.MumpsRoutine;
import analyzer.SourceDistribution;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.sonar.api.resources.InputFile;

public class SonarSourceDistributionTest {
    
    @Test
    public void emptyIterator() {
        List<InputFile> inputFiles = new ArrayList<InputFile>();
        SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        assertThat(iterator, notNullValue());
    }
    
    @Test
    public void oneMumpsRoutineIterator() {
        List<InputFile> inputFiles = new ArrayList<InputFile>();
        inputFiles.add(newInputFile());
        SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        assertThat(iterator.next(), notNullValue());
    }

    private InputFile newInputFile() {
        return new InputFile() {

            @Override
            public File getFileBaseDir() {
                return null;
            }

            @Override
            public File getFile() {
                return new File("");
            }

            @Override
            public String getRelativePath() {
                return null;
            }

            @Override
            public InputStream getInputStream() throws FileNotFoundException {
                return null;
            }
        
        };
    }
}
