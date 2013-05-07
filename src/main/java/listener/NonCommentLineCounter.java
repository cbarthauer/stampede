package listener;

import analyzer.Metric;
import grammar.MBaseListener;
import grammar.MParser.CommandContext;
import grammar.MParser.IdentifierContext;
import grammar.MParser.LevelLineContext;

/**
 *
 * @author cbarthauer
 */
public final class NonCommentLineCounter 
        extends MBaseListener 
        implements AntlrMetricListener {
    
    private int nonCommentLineCount;
    private boolean doIncrement;

    public NonCommentLineCounter() {
        nonCommentLineCount = 0;
        doIncrement = true;
    }
    
    @Override
    public final Metric getMetric() {
        return Metric.NCLOC;
    }

    @Override
    public final int getValue() {
        return nonCommentLineCount;
    }

    @Override
    public final void reset() {
        nonCommentLineCount = 0;
    }

    @Override
    public final void enterCommand(CommandContext ctx) {
        increment();
    }

    @Override
    public final void enterIdentifier(IdentifierContext ctx) {
        increment();
    }

    @Override
    public final void exitLevelLine(LevelLineContext ctx) {
        doIncrement = true;
    }

    private void increment() {
        if(doIncrement) {
            nonCommentLineCount++;
            doIncrement = false;
        }
    }    
}
