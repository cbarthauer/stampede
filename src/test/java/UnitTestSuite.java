import analyzer.AntlrRoutineProcessorTest;
import analyzer.FileBasedMumpsRoutineTest;
import analyzer.FileSystemSourceDistributionTest;
import analyzer.InMemoryMetricStoreTest;
import listener.LineCountListenerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AntlrRoutineProcessorTest.class,
    FileBasedMumpsRoutineTest.class,
    FileSystemSourceDistributionTest.class,
    InMemoryMetricStoreTest.class,
    LineCountListenerTest.class
})
public class UnitTestSuite {}
