// Generated from D:\netbeans_projects\MumpsAnalyzer\src\main\java\grammar\M.g4 by ANTLR 4.0

  package grammar;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MBaseListener implements MListener {
	@Override public void enterArgument(MParser.ArgumentContext ctx) { }
	@Override public void exitArgument(MParser.ArgumentContext ctx) { }

	@Override public void enterCmdIf(MParser.CmdIfContext ctx) { }
	@Override public void exitCmdIf(MParser.CmdIfContext ctx) { }

	@Override public void enterCmdRead(MParser.CmdReadContext ctx) { }
	@Override public void exitCmdRead(MParser.CmdReadContext ctx) { }

	@Override public void enterCmdKill(MParser.CmdKillContext ctx) { }
	@Override public void exitCmdKill(MParser.CmdKillContext ctx) { }

	@Override public void enterCmdQuit(MParser.CmdQuitContext ctx) { }
	@Override public void exitCmdQuit(MParser.CmdQuitContext ctx) { }

	@Override public void enterLevelLine(MParser.LevelLineContext ctx) { }
	@Override public void exitLevelLine(MParser.LevelLineContext ctx) { }

	@Override public void enterCmdNew(MParser.CmdNewContext ctx) { }
	@Override public void exitCmdNew(MParser.CmdNewContext ctx) { }

	@Override public void enterRoutine(MParser.RoutineContext ctx) { }
	@Override public void exitRoutine(MParser.RoutineContext ctx) { }

	@Override public void enterCmdFor(MParser.CmdForContext ctx) { }
	@Override public void exitCmdFor(MParser.CmdForContext ctx) { }

	@Override public void enterCmdUnknown(MParser.CmdUnknownContext ctx) { }
	@Override public void exitCmdUnknown(MParser.CmdUnknownContext ctx) { }

	@Override public void enterCmdGoto(MParser.CmdGotoContext ctx) { }
	@Override public void exitCmdGoto(MParser.CmdGotoContext ctx) { }

	@Override public void enterCmdElse(MParser.CmdElseContext ctx) { }
	@Override public void exitCmdElse(MParser.CmdElseContext ctx) { }

	@Override public void enterPostCondition(MParser.PostConditionContext ctx) { }
	@Override public void exitPostCondition(MParser.PostConditionContext ctx) { }

	@Override public void enterCommand(MParser.CommandContext ctx) { }
	@Override public void exitCommand(MParser.CommandContext ctx) { }

	@Override public void enterCmdDo(MParser.CmdDoContext ctx) { }
	@Override public void exitCmdDo(MParser.CmdDoContext ctx) { }

	@Override public void enterCmdWrite(MParser.CmdWriteContext ctx) { }
	@Override public void exitCmdWrite(MParser.CmdWriteContext ctx) { }

	@Override public void enterCmdSet(MParser.CmdSetContext ctx) { }
	@Override public void exitCmdSet(MParser.CmdSetContext ctx) { }

	@Override public void enterComment(MParser.CommentContext ctx) { }
	@Override public void exitComment(MParser.CommentContext ctx) { }

	@Override public void enterIdentifier(MParser.IdentifierContext ctx) { }
	@Override public void exitIdentifier(MParser.IdentifierContext ctx) { }

	@Override public void enterCmdXecute(MParser.CmdXecuteContext ctx) { }
	@Override public void exitCmdXecute(MParser.CmdXecuteContext ctx) { }

	@Override public void enterCmdUse(MParser.CmdUseContext ctx) { }
	@Override public void exitCmdUse(MParser.CmdUseContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}