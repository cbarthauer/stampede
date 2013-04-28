package sonar;

import grammar.MLexer;
import java.io.IOException;
import java.util.List;
import net.sourceforge.pmd.cpd.SourceCode;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author cbarthauer
 */
public class MumpsCpdMappingTest {
    @Test
    public void shouldSupportMumpsLanguage() {
        MumpsCpdMapping mapping = new MumpsCpdMapping(new Mumps());
        assertThat(mapping.getLanguage(), instanceOf(Mumps.class));
    }
    
    @Test
    public void shouldTokenizeMumpsLanguage() {
        MumpsCpdMapping mapping = new MumpsCpdMapping(new Mumps());
        assertThat(mapping.getTokenizer(), instanceOf(MumpsTokenizer.class));
    }
    
    @Test
    public void outputMLexerTokens() throws IOException {
        String fileName = 
                "D:\\mspace\\VistA-FOIA\\Packages\\Toolkit\\Routines\\XINDEX.m";
        ANTLRInputStream input = new ANTLRFileStream(fileName);
//        ANTLRInputStream input = new ANTLRInputStream("HELLO ;This is the comment.\n");
        MLexer lexer = new MLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);    
        
//        List<Token> antlrTokens = tokenStream.getTokens();
        
        final int eof = -1;
        Token antlrToken = tokenStream.LT(1);
        int currentTokenType = antlrToken.getType();
        
        while(currentTokenType != eof) {
            tokenStream.consume();
            System.out.println(
                    antlrToken.getType() 
                    + ": " 
                    + antlrToken.getText()
                    + " - "
                    + MLexer.tokenNames[antlrToken.getType()]);
            antlrToken = tokenStream.LT(1);
            currentTokenType = antlrToken.getType();
        }
        
    }
}
