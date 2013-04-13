package sonar;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;

/**
 * This class implements a plugin for integrating the MUMPS 
 * programming language with the Sonar framework.
 * 
 * @author cbarthauer
 */
public final class MumpsPlugin extends SonarPlugin {

    @Override
    public final List<?> getExtensions() {
        return Arrays.asList(
                Mumps.class,
                MumpsSourceImporter.class,
                MumpsSensor.class);
    }
}
