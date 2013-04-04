import main.MumpsAnalyzerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sonar.LocTest;

@RunWith(Suite.class)
@SuiteClasses({
    LocTest.class,
    MumpsAnalyzerTest.class
})
public class AcceptanceTestSuite {}
