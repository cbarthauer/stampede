package sonar;

import org.sonar.api.resources.AbstractLanguage;

public final class Mumps extends AbstractLanguage {

    private static final String[] EXTENSIONS = {"m"};
    static final String KEY = "mumps";

    public Mumps() {
        super("mumps", "MUMPS");
    }

    @Override
    public String[] getFileSuffixes() {
        return EXTENSIONS.clone();
    }
}
