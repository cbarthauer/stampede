/**
 * Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
 *
 * This file is part of STAMPEDE.
 *
 * STAMPEDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * STAMPEDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
package listener;

import analyzer.Metric;
import grammar.MBaseListener;
import grammar.MParser.CommandContext;
import grammar.MParser.CommentContext;
import grammar.MParser.EntryLabelContext;
import grammar.MParser.LevelLineContext;

/**
 * This class counts comment-only lines for MUMPS routines.
 * 
 * @author cbarthauer
 */
public final class CommentLineCounter
        extends MBaseListener
        implements AntlrMetricListener {

    private int commentLineCount;
    private boolean hasComment;
    private boolean hasCommentOnly;
   
    /**
     * Create CommentLineCounter with initial line count of zero.
     */
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
