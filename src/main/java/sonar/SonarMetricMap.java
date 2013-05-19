/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sonar;

import analyzer.Metric;
import java.util.HashMap;
import org.sonar.api.BatchExtension;
import org.sonar.api.measures.CoreMetrics;

/**
 * This class maps STAMPEDE metrics to equivalent
 * Sonar metrics. This class uses "code as
 * configuration"; hard-code new metric mappings 
 * in this class's constructor (and nowhere else).
 * 
 * @author cbarthauer
 */
public final class SonarMetricMap 
        extends HashMap<Metric, org.sonar.api.measures.Metric> 
        implements BatchExtension {
    
    private final HashMap<Metric, org.sonar.api.measures.Metric> sonarMetricMap;
    
    /**
     * Create a new SonarMetricMap initialized with the 
     * proper mappings.
     */
    public SonarMetricMap() {
        sonarMetricMap = new HashMap<Metric, org.sonar.api.measures.Metric>();
        sonarMetricMap.put(Metric.LOC, CoreMetrics.LINES);
        sonarMetricMap.put(Metric.NCLOC, CoreMetrics.NCLOC);
        sonarMetricMap.put(Metric.COMMENT_LINES, CoreMetrics.COMMENT_LINES);
    }

    @Override
    public final org.sonar.api.measures.Metric get(Object key) {
        return sonarMetricMap.get(key);
    }

}
