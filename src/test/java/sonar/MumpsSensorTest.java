package sonar;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.RuleFinder;
import utils.TestingConstants;

public class MumpsSensorTest {
    
    @Test
    public void shouldExecuteOnMumpsProject() {
        RuleFinder ruleFinder = new NullRuleFinder();
        SonarConfiguration config = new SonarConfiguration(ruleFinder);
        MumpsSensor sensor = new MumpsSensor(config);
        Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        assertThat(sensor.shouldExecuteOnProject(project), equalTo(true));
    }
    
}
