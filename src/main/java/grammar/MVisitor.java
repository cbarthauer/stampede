/**
 * Copyright (C) 2013 Chris Barthauer <cbarthauer@gmail.com>
 *
 * This file is part of MumpsAnalyzer.
 *
 * MumpsAnalyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MumpsAnalyzer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MumpsAnalyzer.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
// Generated from D:\netbeans_projects\MumpsAnalyzer\src\grammar\M.g4 by ANTLR 4.0

  package grammar;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MVisitor<T> extends ParseTreeVisitor<T> {
	T visitArgument(MParser.ArgumentContext ctx);

	T visitCmdIf(MParser.CmdIfContext ctx);

	T visitCmdRead(MParser.CmdReadContext ctx);

	T visitCmdKill(MParser.CmdKillContext ctx);

	T visitCmdQuit(MParser.CmdQuitContext ctx);

	T visitLevelLine(MParser.LevelLineContext ctx);

	T visitCmdNew(MParser.CmdNewContext ctx);

	T visitRoutine(MParser.RoutineContext ctx);

	T visitCmdFor(MParser.CmdForContext ctx);

	T visitCmdUnknown(MParser.CmdUnknownContext ctx);

	T visitCmdGoto(MParser.CmdGotoContext ctx);

	T visitCmdElse(MParser.CmdElseContext ctx);

	T visitPostCondition(MParser.PostConditionContext ctx);

	T visitCommand(MParser.CommandContext ctx);

	T visitCmdDo(MParser.CmdDoContext ctx);

	T visitCmdWrite(MParser.CmdWriteContext ctx);

	T visitCmdSet(MParser.CmdSetContext ctx);

	T visitComment(MParser.CommentContext ctx);

	T visitIdentifier(MParser.IdentifierContext ctx);

	T visitCmdXecute(MParser.CmdXecuteContext ctx);

	T visitCmdUse(MParser.CmdUseContext ctx);
}