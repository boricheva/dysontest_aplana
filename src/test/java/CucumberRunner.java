import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/"},
        glue = {"steps"},
        plugin = {"ru.yandex.qatools.allure.cucumberjvm.AllureReporter", "pretty"}
)
public class CucumberRunner {

}
