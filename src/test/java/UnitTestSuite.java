import analyzer.AntlrRoutineProcessorTest;
import analyzer.FileBasedMumpsRoutineTest;
import analyzer.FileSystemSourceDistributionTest;
import grammar.LineCountListenerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AntlrRoutineProcessorTest.class,
    FileBasedMumpsRoutineTest.class,
    FileSystemSourceDistributionTest.class,
    LineCountListenerTest.class
})
public class UnitTestSuite {}
