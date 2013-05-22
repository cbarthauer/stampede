package sonar;

import analyzer.Metric;
import analyzer.MetricResult;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import org.junit.Rule;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.Violation;
import utils.TestingConstants;

public class PhysicalLinesAggregateViolationHandlerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery(); 
    
    @Test
    public void shouldIgnoreEmptyMetricResults() {
        final RuleFinder ruleFinder = context.mock(RuleFinder.class);
        final MetricResultHandler handler = 
                new PhysicalLinesAggregateViolationHandler(ruleFinder);
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final List<MetricResult> metricResults = context.mock(List.class);
        
        context.checking(new Expectations() {{
            oneOf(ruleFinder).findByKey(
                    MumpsRuleRepository.KEY, 
                    "physicalLinesAggregate");
            oneOf(metricResults).iterator();
            never(sensorContext).saveViolation(with(any(Violation.class)));
        }});
        
        handler.save(project, sensorContext, metricResults);        
    }
    
    @Test
    public void shouldNotSaveViolationIfCommentLinesPlusNclocEqualsLoc() {
        final RuleFinder ruleFinder = context.mock(RuleFinder.class);
        final MetricResultHandler handler = 
                new PhysicalLinesAggregateViolationHandler(ruleFinder);
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final MetricResult result = context.mock(MetricResult.class);
        final List<MetricResult> metricResults = Arrays.asList(result);
        
        context.checking(new Expectations() {{
            oneOf(ruleFinder).findByKey(
                    MumpsRuleRepository.KEY, 
                    "physicalLinesAggregate");
            oneOf(result).getDouble(Metric.LOC);
            will(returnValue(2.0));
            oneOf(result).getDouble(Metric.NCLOC);
            will(returnValue(1.0));
            oneOf(result).getDouble(Metric.COMMENT_LINES);
            will(returnValue(1.0));
            never(sensorContext).saveViolation(with(any(Violation.class)));
        }});
        
        handler.save(project, sensorContext, metricResults);          
    }
    
    @Test
    public void shouldSaveViolationIfCommentLinesPlusNclocLessThanLoc() {
        final RuleFinder ruleFinder = context.mock(RuleFinder.class);
        final MetricResultHandler handler = 
                new PhysicalLinesAggregateViolationHandler(ruleFinder);
        final Project project = new MumpsProject(TestingConstants.VISTA_TOOLKIT_PATH);
        final SensorContext sensorContext = context.mock(SensorContext.class);
        final MetricResult result = context.mock(MetricResult.class);
        final List<MetricResult> metricResults = Arrays.asList(result);
        
        context.checking(new Expectations() {{
            oneOf(ruleFinder).findByKey(
                    MumpsRuleRepository.KEY, 
                    "physicalLinesAggregate");
            will(returnValue(new org.sonar.api.rules.Rule()));
            oneOf(result).getDouble(Metric.LOC);
            will(returnValue(3.0));
            oneOf(result).getDouble(Metric.NCLOC);
            will(returnValue(1.0));
            oneOf(result).getDouble(Metric.COMMENT_LINES);
            will(returnValue(1.0));
            oneOf(result).getPath();
            will(returnValue(TestingConstants.VISTA_XINDEX_PATH));
            oneOf(sensorContext).saveViolation(with(any(Violation.class)));
        }});
        
        handler.save(project, sensorContext, metricResults);
    }
}
