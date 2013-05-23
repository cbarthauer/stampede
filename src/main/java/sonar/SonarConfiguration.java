package sonar;

import analyzer.Metric;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sonar.api.BatchExtension;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.rules.RuleFinder;

/**
 * This class uses "code as configuration" to provide
 * the MumpsSensor with its runtime settings.
 * 
 * @author cbarthauer
 */
public final class SonarConfiguration 
        implements BatchExtension {
    
    private final List<MetricResultHandler> metricResultHandlers;
    private final Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap;
    private final List<SyntaxErrorHandler> syntaxErrorHandlers;
    
    /**
     * Create a new SonarConfiguration initialized with the 
     * given ruleFinder and hard coded configuration.
     * 
     * @param ruleFinder injected by Sonar framework
     */
    public SonarConfiguration(RuleFinder ruleFinder) {
        sonarMetricMap = new HashMap<Metric, org.sonar.api.measures.Metric>();
        sonarMetricMap.put(Metric.LOC, CoreMetrics.LINES);
        sonarMetricMap.put(Metric.NCLOC, CoreMetrics.NCLOC);
        sonarMetricMap.put(Metric.COMMENT_LINES, CoreMetrics.COMMENT_LINES);
        
        metricResultHandlers = Arrays.asList(
                new StampedeMetricResultHandler(sonarMetricMap),
                new PhysicalLinesAggregateViolationHandler(ruleFinder));
        
        syntaxErrorHandlers = new ArrayList<SyntaxErrorHandler>();
        syntaxErrorHandlers.add(new SyntaxErrorViolationHandler(ruleFinder));
    }

    /**
     * Returns a map of STAMPEDE metrics to equivalent
     * Sonar metrics. Hard-code new metric mappings 
     * in this class's constructor (and nowhere else).
     * 
     * @return Map of STAMPEDE metrics to Sonar metrics.
     */
    final Map<Metric, org.sonar.api.measures.Metric> getMetricMap() {
        return new HashMap<Metric, org.sonar.api.measures.Metric>(sonarMetricMap);
    }

    /**
     * Returns a list of MetricResultHandlers which define how MumpsSensor
     * will tally metric results.
     * 
     * @return List of MetricResultHandlers.
     */
    final List<MetricResultHandler> getMetricResultHandlers() {
        return new ArrayList<MetricResultHandler>(metricResultHandlers);
    }

    /**
     * Returns a list of SyntaxErrorHandlers which define how MumpsSensor
     * will tally syntax errors.
     * 
     * @return List of SyntaxErrorHandlers.
     */
    final List<SyntaxErrorHandler> getSyntaxErrorHandlers() {
        return new ArrayList<SyntaxErrorHandler>(syntaxErrorHandlers);
    }
}
