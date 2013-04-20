package listener;

import analyzer.MumpsRoutine;
import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;

/**
 *
 * @author cbarthauer
 */
public interface ParserErrorListener extends ANTLRErrorListener {
    public List<AntlrError> getParserErrors();

    public void setMumpsRoutine(MumpsRoutine routine);
}
