package listener;

import analyzer.AntlrParserError;
import analyzer.MumpsRoutine;
import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;

/**
 *
 * @author cbarthauer
 */
public interface ParserErrorListener extends ANTLRErrorListener {
    public List<AntlrParserError> getParserErrors();

    public void setMumpsRoutine(MumpsRoutine routine);
}
