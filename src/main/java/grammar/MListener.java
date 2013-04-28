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