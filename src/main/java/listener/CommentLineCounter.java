package listener;

import analyzer.Metric;
import grammar.MBaseListener;
import grammar.MParser.CommandContext;
import grammar.MParser.CommentContext;
import grammar.MParser.EntryLabelContext;
import grammar.MParser.LevelLineContext;

/**
 *
 * @author cbarthauer
 */
public final class CommentLineCounter
        extends MBaseListener
        implements AntlrMetricListener {

    private int commentLineCount;
    private boolean hasComment;
    private boolean hasCommentOnly;
    
    public CommentLineCounter() {
        commentLineCount = 0;
        initializeFlags();
    }
    
    @Override
    public final Metric getMetric() {
        return Metric.COMMENT_LINES;
    }

    @Override
    public final int getValue() {
        return commentLineCount;
    }

    @Override
    public final void reset() {
        commentLineCount = 0;
    }
    
    @Override
    public final void enterCommand(CommandContext ctx) {
        hasCommentOnly = false;
    }

    @Override
    public final void enterComment(CommentContext ctx) {
        hasComment = true;
    }
    
    @Override
    public final void enterEntryLabel(EntryLabelContext ctx) {
        hasCommentOnly = false;
    }

    @Override
    public final void exitLevelLine(LevelLineContext ctx) {
        if(hasComment && hasCommentOnly) {
            commentLineCount++;
        }
        
        initializeFlags();
    }

    private void initializeFlags() {
        hasComment = false;
        hasCommentOnly = true;
    }
}
