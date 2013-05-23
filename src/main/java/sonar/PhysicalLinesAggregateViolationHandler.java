package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import java.util.List;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.File;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;

/**
 * This class saves a violation in Sonar for any M routine where
 * LOC does not equal NCLOC plus COMMENT_LINES.
 * 
 * @author cbarthauer
 */
final class PhysicalLinesAggregateViolationHandler
        implements MetricResultHandler {

    private final RuleFinder ruleFinder;
    
    /**
     * Create a PhysicalLinesAggregateViolationHandler configured
     * with the give RuleFinder.
     * 
     * @param ruleFinder used to locate physicalLinesAggregate rule.
     */
    PhysicalLinesAggregateViolationHandler(RuleFinder ruleFinder) {
        this.ruleFinder = ruleFinder;
    }
    
    @Override
    public void save(
            Project project, 
            SensorContext context, 
            List<MetricResult> metricResults) {
        
        Rule rule = ruleFinder.findByKey(
                MumpsRuleRepository.KEY, 
                "physicalLinesAggregate");
        
        for(MetricResult result : metricResults) {
            double lines = result.getDouble(Metric.LOC);
            double ncloc = result.getDouble(Metric.NCLOC);
            double commentLines = result.getDouble(Metric.COMMENT_LINES);
            
            if(!(lines == ncloc + commentLines)) {
                File sonarFile = File.fromIOFile(
                        new java.io.File(result.getPath()),
                        project);
                sonarFile.setEffectiveKey(
                        project.getKey() + ":" + sonarFile.getKey());
                Violation violation = Violation.create(rule, sonarFile)
                    .setLineId(1)
                    .setMessage(rule.getDescription());
                context.saveViolation(violation);
            }
        }
    }
}
