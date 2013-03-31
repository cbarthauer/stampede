package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FileSystemSourceDistribution implements SourceDistribution {
    private final File file;
    private final String MUMPS_FILE_EXTENSION = ".m";
    private List<MumpsRoutine> routineList;    

    public FileSystemSourceDistribution(File file) {
        this.file = file;
        this.routineList = new ArrayList<MumpsRoutine>();
    }

    @Override
    public final Iterator<MumpsRoutine> iterator() {
        traverse(file);
        return new ArrayList<MumpsRoutine>(routineList).iterator();
    }

    private void traverse(File file) {
        if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                traverse(f);
            }
        }
        else {
            if(file.getPath().endsWith(MUMPS_FILE_EXTENSION)) {
                routineList.add(new FileBasedMumpsRoutine(file));
            }
        }
    }    
}
