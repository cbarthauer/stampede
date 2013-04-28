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
package sonar;

import grammar.MLexer;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
        assertThat(mapping.getTokenizer(), instanceOf(AntlrMumpsTokenizer.class));
    }
    
    @Ignore
    @Test
    public void outputMLexerTokens() throws IOException {
        String fileName = 
                "D:\\mspace\\VistA-FOIA\\Packages\\Toolkit\\Routines\\XINDEX.m";
        ANTLRInputStream input = new ANTLRFileStream(fileName);
//        ANTLRInputStream input = new ANTLRInputStream("HELLO ;This is the comment.\n");
        MLexer lexer = new MLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);    
        final int eof = -1;
        Token antlrToken = tokenStream.LT(1);
        
        while(antlrToken.getType() != eof) {
            tokenStream.consume();
            System.out.println(
                    antlrToken.getType() 
                    + ": " 
                    + antlrToken.getText()
                    + " - "
                    + MLexer.tokenNames[antlrToken.getType()]);
            antlrToken = tokenStream.LT(1);
        }
        
    }
}
