package analyzer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileBasedMumpsRoutine implements MumpsRoutine {
    private final File file;
    private final int EOF = -1;

    public FileBasedMumpsRoutine(File file) {
        this.file = file;
    }

    @Override
    public final String asString() {
        StringBuilder builder = new StringBuilder("");
        
        try {
            FileReader fr = new FileReader(file);
            int currentCharacter = EOF;      
            
            while((currentCharacter = fr.read()) != EOF) {
                builder.append(new Character((char) currentCharacter));
            }
        } catch (IOException ex) {
            Logger.getLogger(FileBasedMumpsRoutine.class.getName())
                    .log(Level.SEVERE, 
                        "Error reading file: " + file.getPath(), 
                        ex);
        }
        
        return builder.toString();
    }    

    @Override
    public final String identifier() {
        return file.getPath();
    }
}
