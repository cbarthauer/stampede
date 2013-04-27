package sonar;

import net.sourceforge.pmd.cpd.SourceCode;
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
}
