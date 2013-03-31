package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileSystemSourceDistributionTest {
    private static final String VISTA_FOIA_PATH = "D:/mspace/VistA-FOIA";
    
    @Test
    public void countFilesInDistribution() {
        File file = new File(VISTA_FOIA_PATH);
        SourceDistribution distribution = new FileSystemSourceDistribution(
                file);
        List<MumpsRoutine> routineList = new ArrayList<MumpsRoutine>();
        Iterator<MumpsRoutine> routineIterator = distribution.iterator();
        
        while(routineIterator.hasNext()) {
            routineList.add(routineIterator.next());
        }
        
        assertThat(25074, equalTo(routineList.size()));
    }
}
