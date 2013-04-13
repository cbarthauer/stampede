package grammar;

import analyzer.Metric;
import analyzer.MetricListener;

/**
 * This class counts lines of code for MUMPS routines.
 * 
 * @author cbarthauer
 */
public final class LineCountListener implements MetricListener {
    private int lineCount;

    /**
     * Create LineCountListener with initial line count of zero.
     */
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
