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

import java.util.List;
import main.StampedeAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
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
    
    private final List<MetricResultHandler> metricResultHandlers;
    private final List<SyntaxErrorHandler> syntaxErrorHandlers;
    

    /**
     * Create a MumpsSensor configured with the given RuleFinder.
     * Called by the Sonar dependency injection mechanism.
     *
     * @param config contains Sonar runtime configuration.
     */
    public MumpsSensor(SonarConfiguration config) {
        this.metricResultHandlers = config.getMetricResultHandlers();
        this.syntaxErrorHandlers = config.getSyntaxErrorHandlers();
    }
    
    @Override
    public final boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public final void analyse(Project project, SensorContext context) {
        if (Qualifiers.MODULE.equals(project.getQualifier())) {
            List<InputFile> inputFiles = project.getFileSystem().mainFiles(Mumps.KEY);
            StampedeAnalyzer analyzer = 
                    SonarMumpsAnalyzerFactory.getMumpsAnalyzer(inputFiles);
            analyzer.analyze();

            for(MetricResultHandler handler : metricResultHandlers) {
                handler.save(project, context, analyzer.metricResults());
            }

            for(SyntaxErrorHandler handler : syntaxErrorHandlers) {
                handler.save(project, context, analyzer.syntaxErrors());
            }
        }
    }
}
