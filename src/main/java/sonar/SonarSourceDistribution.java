package sonar;

import analyzer.FileBasedMumpsRoutine;
import analyzer.MumpsRoutine;
import analyzer.SourceDistribution;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.sonar.api.resources.InputFile;

class SonarSourceDistribution implements SourceDistribution {
    private final List<InputFile> inputFiles;

    /**
     * Create a new SonarSourceDistribution backed by the given
     * inputFiles.
     * 
     * @param inputFiles comprising the source distribution.
     */
    SonarSourceDistribution(List<InputFile> inputFiles) {
        this.inputFiles = new ArrayList<InputFile>(inputFiles);
    }

    @Override
    public Iterator<MumpsRoutine> iterator() {
        List<MumpsRoutine> routines = new ArrayList<MumpsRoutine>();
        
        for(InputFile inputFile : inputFiles) {
            routines.add(new FileBasedMumpsRoutine(inputFile.getFile()));
        }
        
        return routines.iterator();
    }
    
}
