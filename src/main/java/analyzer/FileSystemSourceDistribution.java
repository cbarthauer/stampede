package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class models a collection of MUMPS routines backed by
 * the file system (i.e., MUMPS source code stored in text files).
 * 
 * @author cbarthauer
 */
public final class FileSystemSourceDistribution implements SourceDistribution {
    private final File file;
    private final String mumpsFileExtension = ".m";
    private final List<MumpsRoutine> routineList;    

    /**
     * Create a FileBasedMumpsRoutine backed by the given file. The file may be
     * either a single file or a directory. Directories will be traversed
     * recursively in search of MUMPS source code files (i.e. files ending with
     * a .m extension).
     * 
     * @param file or directory containing the source code for one or more MUMPS 
     * routines.
     */
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
            if(file.getPath().endsWith(mumpsFileExtension)) {
                routineList.add(new FileBasedMumpsRoutine(file));
            }
        }
    }    
}
