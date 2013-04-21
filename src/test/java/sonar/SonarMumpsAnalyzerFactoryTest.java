/**
 * Copyright (C) 2013 Chris Barthauer <mumpsanalyzer@gmail.com>
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sonar;

import analyzer.MetricStore;
import java.util.ArrayList;
import main.MumpsAnalyzer;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sonar.api.resources.InputFile;

/**
 *
 * @author cbarthauer
 */
public class SonarMumpsAnalyzerFactoryTest {
    
    @Test
    public void shouldProcessEmptyListOfInputFiles() {
        MumpsAnalyzer analyzer = 
                SonarMumpsAnalyzerFactory.getMumpsAnalyzer(
                    new ArrayList<InputFile>());
        analyzer.analyze();
        assertThat(analyzer.metricResults().size(), equalTo(0));
    }
    
}
