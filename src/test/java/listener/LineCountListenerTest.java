package listener;

import listener.LineCountListener;
import analyzer.MetricListener;
import grammar.MListener;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineCountListenerTest {
    @Test
    public void countLines() {
        MetricListener metricListener = new LineCountListener();
        MListener listener = metricListener.asMListener();
        listener.enterLevelLine(null);
        listener.enterLevelLine(null);
        assertThat(metricListener.getValue(), equalTo(2));
        
        metricListener.reset();
        assertThat(metricListener.getValue(), equalTo(0));
    }
}
