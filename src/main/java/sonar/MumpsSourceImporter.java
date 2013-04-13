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
package sonar;

import org.sonar.api.batch.AbstractSourceImporter;

/**
 * This class handles importing MUMPS source code into Sonar.
 * 
 * @author cbarthauer
 */
public final class MumpsSourceImporter extends AbstractSourceImporter {

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
}
