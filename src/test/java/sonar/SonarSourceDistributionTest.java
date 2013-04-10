package sonar;

import analyzer.MumpsRoutine;
import analyzer.SourceDistribution;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.sonar.api.resources.InputFile;

public class SonarSourceDistributionTest {
    
    @Test
    public void emptyIterator() {
        List<InputFile> inputFiles = new ArrayList<InputFile>();
        SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        assertThat(iterator, notNullValue());
    }
    
    @Test
    public void oneMumpsRoutineIterator() {
        List<InputFile> inputFiles = new ArrayList<InputFile>();
        inputFiles.add(newInputFile());
        SourceDistribution distribution = new SonarSourceDistribution(inputFiles);
        Iterator<MumpsRoutine> iterator = distribution.iterator();
        assertThat(iterator.next(), notNullValue());
    }

    private InputFile newInputFile() {
        return new InputFile() {

            @Override
            public File getFileBaseDir() {
                return null;
            }

            @Override
            public File getFile() {
                return new File("");
            }

            @Override
            public String getRelativePath() {
                return null;
            }

            @Override
            public InputStream getInputStream() throws FileNotFoundException {
                return null;
            }
        
        };
    }
}
