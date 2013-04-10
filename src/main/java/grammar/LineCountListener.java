package grammar;

import analyzer.Metric;
import analyzer.MetricListener;

public final class LineCountListener implements MetricListener {
    private int lineCount;

    public LineCountListener() {
        lineCount = 0;
    }
    
    @Override
    public final MListener asMListener() {
        return new MBaseListener() {
            @Override
            public final void enterLevelLine(MParser.LevelLineContext ctx) { 
                lineCount++;
            }
        };
    }
    
    @Override
    public final Metric getMetric() {
        return Metric.LOC;
    }
    
    @Override
    public final int getValue() {
        return lineCount;
    }

    @Override
    public final void reset() {
        lineCount = 0;
    }
}
