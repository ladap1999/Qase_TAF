package scenarioRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        monochrome = true,
        strict = true,
        plugin = {"pretty"},
        glue = {"stepDefs"},
        tags = "@api or @ui"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
