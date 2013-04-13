package sonar;

import org.sonar.api.batch.AbstractSourceImporter;

/**
 * This class handles importing MUMPS source code into Sonar.
 * 
 * @author cbarthauer
 */
public final class MumpsSourceImporter extends AbstractSourceImporter {

    /**
     * Creates a MumpsSourceImporter object. Called by the Sonar
     * framework.
     * 
     * @param mumps object representing the MUMPS programming language
     * in Sonar.
     */
    public MumpsSourceImporter(Mumps mumps) {
        super(mumps);
    }
}
