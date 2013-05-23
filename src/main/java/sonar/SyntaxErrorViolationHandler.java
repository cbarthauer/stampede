package sonar;

import analyzer.MumpsSyntaxError;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;

/**
 * This class saves M syntax errors in Sonar as violations.
 * 
 * @author cbarthauer
 */
final class SyntaxErrorViolationHandler
        implements SyntaxErrorHandler {
    
    private final RuleFinder ruleFinder;

    /**
     * Create a new SyntaxErrorViolationHandler initialized
     * with the given ruleFinder.
     * 
     * @param ruleFinder used to locate syntaxError rule.
     */
    SyntaxErrorViolationHandler(RuleFinder ruleFinder) {
        this.ruleFinder = ruleFinder;
    }

    @Override
    public final void save(
            Project project, 
            SensorContext context, 
            List<MumpsSyntaxError> syntaxErrors) {
        
        Rule rule = ruleFinder.findByKey(MumpsRuleRepository.KEY, "syntaxError");
        
        for(MumpsSyntaxError error : syntaxErrors) {
            File sonarFile = File.fromIOFile(
                    new java.io.File(error.getIdentifier()),
                    project);
            sonarFile.setEffectiveKey(
                    project.getKey() + ":" + sonarFile.getKey());
            Violation violation = Violation.create(rule, sonarFile)
                    .setLineId(error.getLine())
                    .setMessage("[line: " + error.getLine() 
                        + ", column: " + error.getCharPositionInLine() 
                        + "] " + error.getMessage());
            context.saveViolation(violation);
        }
    }
}
