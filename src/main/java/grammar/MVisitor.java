// Generated from D:\netbeans_projects\stampede\src\main\java\grammar\M.g4 by ANTLR 4.0

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

	T visitBlockLevel(MParser.BlockLevelContext ctx);

	T visitCmdNew(MParser.CmdNewContext ctx);

	T visitRoutine(MParser.RoutineContext ctx);

	T visitCmdFor(MParser.CmdForContext ctx);

	T visitCmdUnknown(MParser.CmdUnknownContext ctx);

	T visitCmdGoto(MParser.CmdGotoContext ctx);

	T visitCmdElse(MParser.CmdElseContext ctx);

	T visitPostCondition(MParser.PostConditionContext ctx);

	T visitEntryLabel(MParser.EntryLabelContext ctx);

	T visitCommand(MParser.CommandContext ctx);

	T visitCmdDo(MParser.CmdDoContext ctx);

	T visitCmdWrite(MParser.CmdWriteContext ctx);

	T visitCmdSet(MParser.CmdSetContext ctx);

	T visitComment(MParser.CommentContext ctx);

	T visitIdentifier(MParser.IdentifierContext ctx);

	T visitCmdXecute(MParser.CmdXecuteContext ctx);

	T visitCmdUse(MParser.CmdUseContext ctx);
}