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

	@Override public T visitComment(MParser.CommentContext ctx) { return visitChildren(ctx); }

	@Override public T visitIdentifier(MParser.IdentifierContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdXecute(MParser.CmdXecuteContext ctx) { return visitChildren(ctx); }

	@Override public T visitCmdUse(MParser.CmdUseContext ctx) { return visitChildren(ctx); }
}