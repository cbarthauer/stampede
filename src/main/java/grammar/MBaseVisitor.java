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
// Generated from D:\netbeans_projects\MumpsAnalyzer\src\main\java\grammar\M.g4 by ANTLR 4.0

  package grammar;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class MBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MVisitor<T> {
	@Override public T visitArgument(MParser.ArgumentContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdIf(MParser.CmdIfContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdRead(MParser.CmdReadContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdKill(MParser.CmdKillContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdQuit(MParser.CmdQuitContext ctx) { return visitChildren(ctx); }

	@Override public T visitLevelLine(MParser.LevelLineContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdNew(MParser.CmdNewContext ctx) { return visitChildren(ctx); }

	@Override public T visitRoutine(MParser.RoutineContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdFor(MParser.CmdForContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdUnknown(MParser.CmdUnknownContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdGoto(MParser.CmdGotoContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdElse(MParser.CmdElseContext ctx) { return visitChildren(ctx); }

	@Override public T visitPostCondition(MParser.PostConditionContext ctx) { return visitChildren(ctx); }

	@Override public T visitCommand(MParser.CommandContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdDo(MParser.CmdDoContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdWrite(MParser.CmdWriteContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdSet(MParser.CmdSetContext ctx) { return visitChildren(ctx); }

	@Override public T visitIdentifier(MParser.IdentifierContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdXecute(MParser.CmdXecuteContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdUse(MParser.CmdUseContext ctx) { return visitChildren(ctx); }
}