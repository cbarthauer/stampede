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

import java.io.File;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.AbstractSourceImporter;
import org.sonar.api.resources.Resource;

/**
 * This class handles importing MUMPS source code into Sonar.
 * 
 * @author cbarthauer
 */
public final class MumpsSourceImporter extends AbstractSourceImporter {
    private static final Logger LOG = LoggerFactory.getLogger(MumpsSensor.class);
    
    /**
     * Creates a MumpsSourceImporter object. Called by the Sonar
     * framework.
     * 
     * @param mumps object representing the MUMPS programming language
     * in Sonar.
     */
    public MumpsSourceImporter(Mumps mumps) {
        super(mumps);
    }

    @Override
    protected Resource createResource(File file, List<File> sourceDirs, boolean unitTest) {
        LOG.info("Importing: " + file.getAbsolutePath());
        return super.createResource(file, sourceDirs, unitTest);
    }
    
    
}
