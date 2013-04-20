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
package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import analyzer.MetricStore;
import java.util.Iterator;
import java.util.List;
import main.MumpsAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.File;
import org.sonar.api.resources.InputFile;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Qualifiers;

/**
 * This class analyzes a MUMPS source distribution stored in the file system and
 * loads the results into Sonar.
 *
 * @author cbarthauer
 */
public final class MumpsSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(MumpsSensor.class);

    @Override
    public final boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public final void analyse(Project project, SensorContext context) {
        String qualifier = project.getQualifier();

        if (Qualifiers.PROJECT.equals(qualifier)) {
            analyseProject(project, context);
        } else if (Qualifiers.MODULE.equals(qualifier)) {
            analyseModule(project, context);
        }
    }

    private void analyseModule(Project project, SensorContext context) {
        List<InputFile> inputFiles = project.getFileSystem().mainFiles(Mumps.KEY);
        Iterator<MetricResult> iterator = getMetricResultIterator(inputFiles);

        while (iterator.hasNext()) {
            MetricResult result = iterator.next();
            File sonarFile = File.fromIOFile(
                    new java.io.File(result.getPath()),
                    project);

            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());

            context.saveMeasure(
                    sonarFile,
                    CoreMetrics.LINES,
                    result.getDouble(Metric.LOC));
        }
    }

    private void analyseProject(Project project, SensorContext context) {
        //Not implemented.
    }    
    
    private Iterator<MetricResult> getMetricResultIterator(List<InputFile> inputFiles) {
        MumpsAnalyzer analyzer = SonarMumpsAnalyzerFactory.getMumpsAnalyzer(inputFiles);
        MetricStore store = analyzer.analyze();
        return store.iterator();
    }
}
