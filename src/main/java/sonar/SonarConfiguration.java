package sonar;

import analyzer.Metric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sonar.api.BatchExtension;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.rules.RuleFinder;

/**
 * This class uses "code as configuration" to provide
 * the MumpsSensor with its runtime configuration.
 * 
 * @author cbarthauer
 */
public final class SonarConfiguration 
        implements BatchExtension {
    
    private final List<MetricResultHandler> metricResultHandlers;
    private final Map<Metric, org.sonar.api.measures.Metric> sonarMetricMap;
    
    /**
     * Create a new SonarConfiguration initialized with the 
     * proper mappings.
     */
    public SonarConfiguration(RuleFinder ruleFinder) {
        sonarMetricMap = new HashMap<Metric, org.sonar.api.measures.Metric>();
        sonarMetricMap.put(Metric.LOC, CoreMetrics.LINES);
        sonarMetricMap.put(Metric.NCLOC, CoreMetrics.NCLOC);
        sonarMetricMap.put(Metric.COMMENT_LINES, CoreMetrics.COMMENT_LINES);
        
        metricResultHandlers = new ArrayList<MetricResultHandler>();
        metricResultHandlers.add(new StampedeMetricResultHandler(sonarMetricMap));
        metricResultHandlers.add(
                new PhysicalLinesAggregateViolationHandler(ruleFinder));
    }

    /**
     * Returns a map of STAMPEDE metrics to equivalent
     * Sonar metrics. Hard-code new metric mappings 
     * in this class's constructor (and nowhere else).
     * 
     * @return Map of STAMPEDE metrics to Sonar metrics.
     */
    public final Map<Metric, org.sonar.api.measures.Metric> getMetricMap() {
        return new HashMap<Metric, org.sonar.api.measures.Metric>(sonarMetricMap);
    }

    /**
     * Returns a list of MetricResultHandlers which define how MumpsSensor
     * will tally metric results.
     * 
     * @return List of MetricResultHandlers.
     */
    public final List<MetricResultHandler> getMetricResultHandlers() {
        return new ArrayList<MetricResultHandler>(metricResultHandlers);
    }
}
