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

import net.sourceforge.pmd.cpd.Tokenizer;
import org.sonar.api.batch.AbstractCpdMapping;
import org.sonar.api.resources.Language;

/**
 * This class integrates MumpsAnalyzer with Sonar's
 * copy-paste detection (i.e., CPD) mechanism.
 * @author cbarthauer
 */
public final class MumpsCpdMapping extends AbstractCpdMapping {
    private final Mumps language;

    /**
     * Create a MumpsCpdMapping object for the MUMPS
     * language. Called by Sonar's dependency injection
     * mechanism.
     * 
     * @param language MUMPS language object, injected
     * by Sonar framework.
     */
    public MumpsCpdMapping(Mumps language) {
        this.language = language;
    }
    
    @Override
    public final Tokenizer getTokenizer() {
        return new AntlrMumpsTokenizer();
    }

    @Override
    public final Language getLanguage() {
        return language;
    }
    
}
