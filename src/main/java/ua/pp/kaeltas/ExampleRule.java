package ua.pp.kaeltas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.BatchSide;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.server.rule.RulesDefinition;

@BatchSide
public class ExampleRule implements RulesDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleRule.class);

    public ExampleRule() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Rules definition bean is creating.");
        }
    }

    @Override
    public void define(Context context) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Making sonar-rules for the Grammar Plugin using {}", context.toString());
        }
        final NewRepository repository = context
                .createRepository("sonar.test-guava-plugin.repo.key", "java")
                .setName("sonar.test-guava-plugin.repo.name");


        final NewRule exampleRule = repository
                .createRule("sonar.test-guava-plugin.rule.key")
                .setName("test guava rule")
                .setHtmlDescription("test guava description")
                .setStatus(RuleStatus.READY)
                .setInternalKey("sonar.test-guava-plugin.rule.key")
                .setSeverity(Severity.INFO);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Created new rule:{}", exampleRule);
        }
        repository.done();
    }

}
