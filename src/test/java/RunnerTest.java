import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"}, //"json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-reports"
        features = ".//src//test//resources//",
        glue = {"tests"},
        tags = {"@regression"})

public class RunnerTest {

}
