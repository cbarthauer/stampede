package sonar;

import grammar.MLexer;
import java.io.IOException;
import java.util.List;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.TokenEntry;
import net.sourceforge.pmd.cpd.Tokenizer;
import net.sourceforge.pmd.cpd.Tokens;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author cbarthauer
 */
public final class AntlrMumpsTokenizer implements Tokenizer {
    @Override
    public void tokenize(SourceCode source, Tokens pmdTokens) throws IOException {
        String fileName = source.getFileName();
        ANTLRInputStream input = new ANTLRFileStream(fileName);
        MLexer lexer = new MLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);    
        final int eof = -1;
        Token antlrToken = tokenStream.LT(1);
        
        while(antlrToken.getType() != eof) {
            tokenStream.consume();
            TokenEntry pmdToken = new TokenEntry(
                    MLexer.tokenNames[antlrToken.getType()],
                    fileName,
                    antlrToken.getLine());
            pmdTokens.add(pmdToken);
            antlrToken = tokenStream.LT(1);
        }
        
        pmdTokens.add(TokenEntry.getEOF());
    }
}
