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

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;

/**
 * This class implements a plugin for integrating the MUMPS 
 * programming language with the Sonar framework.
 * 
 * @author cbarthauer
 */
public final class MumpsPlugin extends SonarPlugin {

    @Override
    public final List<?> getExtensions() {
        return Arrays.asList(
                Mumps.class,
                MumpsCpdMapping.class,
                MumpsRuleRepository.class,
                MumpsSourceImporter.class,
                MumpsSensor.class);
    }
}
