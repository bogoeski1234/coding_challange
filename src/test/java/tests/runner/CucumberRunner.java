package tests.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"

        },
        features = "src/test/resources/",
        glue = "tests/step_definitions",
        tags = "@git",
        dryRun = false
)
public class CucumberRunner {

}