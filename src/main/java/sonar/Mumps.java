package sonar;

import org.sonar.api.resources.AbstractLanguage;

/**
 * This class models the MUMPS programming language within
 * the Sonar framework.
 * 
 * @author cbarthauer
 */
public final class Mumps extends AbstractLanguage {

    private static final String[] EXTENSIONS = {"m"};
    
    /**
     * The unique identifier for the MUMPS programming language
     * within Sonar.
     */
    static final String KEY = "mumps";

    /**
     * Create a new Mumps object. Called by the Sonar
     * framework.
     */
    public Mumps() {
        super("mumps", "MUMPS");
    }

    @Override
    public String[] getFileSuffixes() {
        return EXTENSIONS.clone();
    }
}
