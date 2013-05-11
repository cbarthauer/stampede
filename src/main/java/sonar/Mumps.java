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

import org.sonar.api.resources.AbstractLanguage;

/**
 * This class models the MUMPS programming language within
 * the Sonar framework.
 * 
 * @author cbarthauer
 */
public final class Mumps extends AbstractLanguage {

    private static final String[] EXTENSIONS = {"m"};
    
    /**
     * The unique identifier for the MUMPS programming language
     * within Sonar.
     */
    static final String KEY = "mumps";

    /**
     * Create a new Mumps object. Called by the Sonar
     * framework.
     */
    public Mumps() {
        super("mumps", "MUMPS");
    }

    @Override
    public String[] getFileSuffixes() {
        return EXTENSIONS.clone();
    }
}
