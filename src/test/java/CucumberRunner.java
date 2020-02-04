import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
        "html:target/default-cucumber-reports", "json:target/cucumber.json", "junit:target/cucumber.xml"},
        features = {"classpath:features/expedia"},
        glue = {"step_defs"},
        //tags = "@expedia",
        dryRun = false)
public class CucumberRunner {
}
