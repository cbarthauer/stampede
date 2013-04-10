package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileSystemSourceDistributionTest {
    private static final String VISTA_FOIA_PATH = "D:\\mspace\\VistA-FOIA";
    private static final String ACCOUNTS_RECEIVABLE_PATH = "D:\\mspace\\VistA-FOIA\\Packages\\Accounts Receivable\\Routines";
    
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
    
    @Test
    public void countFilesInAccountsReceivableFolder() {
        File file = new File(ACCOUNTS_RECEIVABLE_PATH);
        SourceDistribution distribution = new FileSystemSourceDistribution(
                file);
        List<MumpsRoutine> routineList = new ArrayList<MumpsRoutine>();
        Iterator<MumpsRoutine> routineIterator = distribution.iterator();
        
        while(routineIterator.hasNext()) {
            routineList.add(routineIterator.next());
        }
        
        assertThat(467, equalTo(routineList.size()));       
    }
}
