package ua.pp.kaeltas;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * This class is the entry point for all extensions
 */
@Properties({
        @Property(
                key = TestGuavaPlugin.MY_PROPERTY,
                name = "Plugin Property",
                description = "A property for the plugin",
                defaultValue = "Hello World!")})
public class TestGuavaPlugin extends SonarPlugin {

    public static final String MY_PROPERTY = "sonar.test-guava-plugin.myproperty";

    @Override
    public List getExtensions() {
        return Arrays
                .asList(
                        ExampleSensor.class,
                        ExampleRule.class
                );
    }
}
