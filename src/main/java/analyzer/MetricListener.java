package analyzer;

import grammar.MListener;

/**
 * This interface models an object which can receive
 * ANTLR parser events via the {@link grammar.MListener}
 * interface. Classes implementing MetricListener are
 * responsible for computing a particular Metric value
 * based on the parser events they receive.
 * 
 * @see analyzer.AntlrRoutineProcessor
 * @author cbarthauer
 */
public interface MetricListener {
    /**
     * Returns an MListener view of this object which can
     * receive ANTLR parser events.
     * 
     * @return An MListener object.
     */
    public MListener asMListener();
    
    /**
     * Get the Metric this MetricListener calculates.
     * 
     * @return The Metric.
     */
    public Metric getMetric();
    
    /**
     * Get the value calculated for this MetricListener's
     * Metric.
     * 
     * @return The value calculated for the Metric.
     */
    public int getValue();
    
    /**
     * Clear any accumulated state (i.e. from previous
     * processing) and re-initialize the MetricListener.
     * After calling reset(), the MetricListener should
     * be ready to begin processing again.
     */
    public void reset();
}
