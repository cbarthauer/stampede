package sonar;

import analyzer.MumpsSyntaxError;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

/**
 * MumpsSensor uses a list of SyntaxErrorHandler objects
 * to handle syntax errors obtained from STAMPEDE.
 * 
 * @author cbarthauer
 */
public interface SyntaxErrorHandler {
    /**
     * Save the give syntaxErrors in Sonar.
     * 
     * @param project associated with syntaxErrors
     * @param context in which to save results
     * @param syntaxErrors to be saved
     */
    public void save(
            Project project, 
            SensorContext context, 
            List<MumpsSyntaxError> syntaxErrors);
}
