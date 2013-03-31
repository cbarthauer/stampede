package analyzer;

import java.io.File;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileBasedMumpsRoutineTest {
    private final String MUMPS_FILE_PATH = 
            "D:\\mspace\\VistA-FOIA\\Packages\\Toolkit\\Routines\\XINDEX.m";
    
    @Test
    public void getSourceCode() {
        MumpsRoutine routine = new FileBasedMumpsRoutine(new File(MUMPS_FILE_PATH));
        assertThat(routine.asString().length(), greaterThan(0));
        assertThat(routine.identifier(), equalTo(MUMPS_FILE_PATH));
    }
}
