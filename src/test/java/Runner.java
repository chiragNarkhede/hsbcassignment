import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:results/cucumber"},
        features = "src/test/resources/Features",
        tags="@smoke and @regression"
        )
public class Runner {

}
