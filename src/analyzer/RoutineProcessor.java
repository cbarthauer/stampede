package analyzer;

import java.util.Map;

public interface RoutineProcessor {
    public Map<String, Map<Metric, Integer>> process(MumpsRoutine routine);
}
