/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sonar;

import analyzer.MetricStore;
import java.util.ArrayList;
import main.MumpsAnalyzer;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sonar.api.resources.InputFile;

/**
 *
 * @author cbarthauer
 */
public class SonarMumpsAnalyzerFactoryTest {
    
    @Test
    public void shouldProcessEmptyListOfInputFiles() {
        MumpsAnalyzer analyzer = 
                SonarMumpsAnalyzerFactory.getMumpsAnalyzer(
                    new ArrayList<InputFile>());
        MetricStore store = analyzer.analyze();
        assertThat(store.iterator().hasNext(), equalTo(false));
    }
    
}
