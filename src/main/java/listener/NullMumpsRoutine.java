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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import analyzer.MumpsRoutine;

/**
 * Represents a MumpsRoutine with no identifier and no source code.
 * This class can act as a placeholder for an actual MumpsRoutine.
 
 * @author cbarthauer
 */
public final class NullMumpsRoutine implements MumpsRoutine {

    @Override
    public final String asString() {
        return "";
    }

    @Override
    public final String identifier() {
        return "";
    }

}
