package analyzer;

import antlr.AntlrRoutineProcessorBuilder;
import listener.AntlrMetricListener;

public final class AntlrRoutineProcessorFactory {
    private AntlrRoutineProcessorFactory() {
        //Hide utility class constructor.
    }
    
    public static RoutineProcessor getRoutineProcessor(
            AntlrMetricListener... listeners) {
        final AntlrRoutineProcessorBuilder builder =
                new AntlrRoutineProcessorBuilder();
        final RoutineProcessor rp =
                builder.setAntlrMetricListeners(listeners)
                .build();
        return rp;
    }
}
