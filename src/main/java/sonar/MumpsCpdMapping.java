package sonar;

import net.sourceforge.pmd.cpd.Tokenizer;
import org.sonar.api.batch.AbstractCpdMapping;
import org.sonar.api.resources.Language;

/**
 *
 * @author cbarthauer
 */
public final class MumpsCpdMapping extends AbstractCpdMapping {
    private final Mumps language;

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
