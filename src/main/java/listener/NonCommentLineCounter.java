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
import grammar.MParser.BlockLevelContext;
import grammar.MParser.CommandContext;
import grammar.MParser.CommentContext;
import grammar.MParser.EntryLabelContext;
import grammar.MParser.LevelLineContext;

/**
 * This class counts non-comment lines of code for MUMPS routines.
 * 
 * @author cbarthauer
 */
public final class NonCommentLineCounter 
        extends MBaseListener 
        implements AntlrMetricListener {
    
    private int nonCommentLineCount;
    private boolean hasBlockLevel;
    private boolean hasComment;
    private boolean hasCommand;
    private boolean hasEntryLabel;

    /**
     * Create NonCommentLineCounter with initial line count of zero.
     */
    public NonCommentLineCounter() {
        nonCommentLineCount = 0;
        initializeFlags();
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
    public void enterBlockLevel(BlockLevelContext ctx) {
        hasBlockLevel = true;
    }

    @Override
    public void enterComment(CommentContext ctx) {
        hasComment = true;
    }
    
    @Override
    public final void enterCommand(CommandContext ctx) {
        hasCommand = true;
    }

    @Override
    public final void enterEntryLabel(EntryLabelContext ctx) {
        hasEntryLabel = true;
    }

    @Override
    public final void exitLevelLine(LevelLineContext ctx) {
        if(hasCommand 
                || hasEntryLabel 
                || (hasBlockLevel && !hasComment)) {
            nonCommentLineCount++;
        }
        
        initializeFlags();
    }

    private void initializeFlags() {
        hasBlockLevel = false;
        hasComment = false;
        hasCommand = false;
        hasEntryLabel = false;
    }
}
