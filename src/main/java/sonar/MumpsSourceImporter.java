package sonar;

import org.sonar.api.batch.AbstractSourceImporter;

public final class MumpsSourceImporter extends AbstractSourceImporter {

    public MumpsSourceImporter(Mumps mumps) {
        super(mumps);
    }
}
