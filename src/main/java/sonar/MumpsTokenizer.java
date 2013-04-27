package sonar;

import com.sonar.sslr.api.Token;
import com.sonar.sslr.impl.Lexer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.TokenEntry;
import net.sourceforge.pmd.cpd.Tokenizer;
import net.sourceforge.pmd.cpd.Tokens;

/**
 *
 * @author cbarthauer
 */
public final class MumpsTokenizer implements Tokenizer {
    @Override
    public final void tokenize(SourceCode source, Tokens mumpsTokens) 
            throws IOException {
        Lexer lexer = MumpsLexer.create();
        String fileName = source.getFileName();
        List<Token> tokens = lexer.lex(new File(fileName));
        
        for (Token token : tokens) {
            TokenEntry cpdToken = 
                    new TokenEntry(
                        token.getValue(), 
                        fileName, 
                        token.getLine());
            mumpsTokens.add(cpdToken);
        }
        
        mumpsTokens.add(TokenEntry.getEOF());
    }
}
