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
import main.StampedeAnalyzerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sonar.LocTest;

@RunWith(Suite.class)
@SuiteClasses({
    LocTest.class,
    StampedeAnalyzerTest.class
})
public class AcceptanceTestSuite {}
