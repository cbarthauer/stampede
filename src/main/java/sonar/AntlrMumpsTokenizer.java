/**
 * Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
 *
 * This file is part of STAMPEDE.
 *
 * STAMPEDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * STAMPEDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
package sonar;

import grammar.MLexer;
import java.io.IOException;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.TokenEntry;
import net.sourceforge.pmd.cpd.Tokenizer;
import net.sourceforge.pmd.cpd.Tokens;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class tokenizes MUMPS source code for Sonar's
 * copy-paste detection mechanism.
 * 
 * @see MumpsCpdMapping
 * @author cbarthauer
 */
public final class AntlrMumpsTokenizer implements Tokenizer {
    private static final Logger LOG = LoggerFactory.getLogger(AntlrMumpsTokenizer.class);
    
    @Override
    public void tokenize(SourceCode source, Tokens pmdTokens) throws IOException {
        LOG.info("Tokenizing file: " + source.getFileName());
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
