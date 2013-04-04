package sonar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Decorator;
import org.sonar.api.batch.DecoratorContext;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;

public final class MumpsDecorator implements Decorator {

    private static final Logger LOG = LoggerFactory.getLogger(MumpsDecorator.class);

    @Override
    public boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().getKey().equals(Mumps.KEY);
    }

    @Override
    public void decorate(Resource resource, DecoratorContext context) {
        LOG.info("MumpsDecorator: " + resource.getKey());
    }
}
