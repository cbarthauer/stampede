package sonar;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

public final class MumpsSensor implements Sensor {
//	private static final Logger LOG = LoggerFactory.getLogger(MumpsSensor.class);

//    private MGrammarExecutor executor;
//
//    public MumpsSensor(MGrammarExecutor executor) {
//        this.executor = executor;
//    }

    @Override
    public final boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public final void analyse(Project project, SensorContext context) {
//        Report report = executor.execute();
//
//        for (MeasureRow row : report.getMeasureRows()) {
//            context.saveMeasure(row.getResource(), row.getMetric(), row.getValue());
//        }
    }
}
