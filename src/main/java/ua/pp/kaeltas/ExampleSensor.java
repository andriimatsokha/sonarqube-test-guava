package ua.pp.kaeltas;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

import java.util.Date;

public class ExampleSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleSensor.class);

    private Settings settings;
    private FileSystem fs;

    /**
     * Use of IoC to get Settings and FileSystem
     */
    public ExampleSensor(Settings settings, FileSystem fs) {
        this.settings = settings;
        this.fs = fs;
    }

    @Override
    public boolean shouldExecuteOnProject(Project project) {
        // This sensor is executed only when there are Java files
        return fs.hasFiles(fs.predicates().hasLanguage("java"));
    }

    @Override
    public void analyse(Project project, SensorContext sensorContext) {
        Optional<Date> optional = Optional.absent();
        // This sensor create a measure for metric MESSAGE on each Java file
        String value = settings.getString(TestGuavaPlugin.MY_PROPERTY);
        LOG.info(TestGuavaPlugin.MY_PROPERTY + "=" + value);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
