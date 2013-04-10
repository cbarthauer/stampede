package analyzer;

import grammar.MListener;

public interface MetricListener {
    public MListener asMListener();
    public Metric getMetric();
    public int getValue();
    public void reset();
}
