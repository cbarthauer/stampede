/**
 * Copyright (C) 2013 Chris Barthauer <mumpsanalyzer@gmail.com>
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
// Generated from D:\netbeans_projects\MumpsAnalyzer\src\main\java\grammar\M.g4 by ANTLR 4.0

  package grammar;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MListener extends ParseTreeListener {
	void enterArgument(MParser.ArgumentContext ctx);
	void exitArgument(MParser.ArgumentContext ctx);

	void enterCmdIf(MParser.CmdIfContext ctx);
	void exitCmdIf(MParser.CmdIfContext ctx);

	void enterCmdRead(MParser.CmdReadContext ctx);
	void exitCmdRead(MParser.CmdReadContext ctx);

	void enterCmdKill(MParser.CmdKillContext ctx);
	void exitCmdKill(MParser.CmdKillContext ctx);

	void enterCmdQuit(MParser.CmdQuitContext ctx);
	void exitCmdQuit(MParser.CmdQuitContext ctx);

	void enterLevelLine(MParser.LevelLineContext ctx);
	void exitLevelLine(MParser.LevelLineContext ctx);

	void enterCmdNew(MParser.CmdNewContext ctx);
	void exitCmdNew(MParser.CmdNewContext ctx);

	void enterRoutine(MParser.RoutineContext ctx);
	void exitRoutine(MParser.RoutineContext ctx);

	void enterCmdFor(MParser.CmdForContext ctx);
	void exitCmdFor(MParser.CmdForContext ctx);

	void enterCmdUnknown(MParser.CmdUnknownContext ctx);
	void exitCmdUnknown(MParser.CmdUnknownContext ctx);

	void enterCmdGoto(MParser.CmdGotoContext ctx);
	void exitCmdGoto(MParser.CmdGotoContext ctx);

	void enterCmdElse(MParser.CmdElseContext ctx);
	void exitCmdElse(MParser.CmdElseContext ctx);

	void enterPostCondition(MParser.PostConditionContext ctx);
	void exitPostCondition(MParser.PostConditionContext ctx);

	void enterCommand(MParser.CommandContext ctx);
	void exitCommand(MParser.CommandContext ctx);

	void enterCmdDo(MParser.CmdDoContext ctx);
	void exitCmdDo(MParser.CmdDoContext ctx);

	void enterCmdWrite(MParser.CmdWriteContext ctx);
	void exitCmdWrite(MParser.CmdWriteContext ctx);

	void enterCmdSet(MParser.CmdSetContext ctx);
	void exitCmdSet(MParser.CmdSetContext ctx);

	void enterIdentifier(MParser.IdentifierContext ctx);
	void exitIdentifier(MParser.IdentifierContext ctx);

	void enterCmdXecute(MParser.CmdXecuteContext ctx);
	void exitCmdXecute(MParser.CmdXecuteContext ctx);

	void enterCmdUse(MParser.CmdUseContext ctx);
	void exitCmdUse(MParser.CmdUseContext ctx);
}