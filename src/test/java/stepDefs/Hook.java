package stepDefs;

import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import baseEntities.BaseCucumberTest;
import com.google.common.io.CharStreams;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import services.WaitsService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static io.restassured.RestAssured.given;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    protected ProjectAdapter projectAdapter;
    protected SuiteAdapter suiteAdapter;
    Logger logger = LogManager.getLogger(Hook.class);
    Logger loggerFile = LogManager.getLogger("File");

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before(value = "@api or @ui", order = 1)
    public void addProject() throws IOException {
        projectAdapter = new ProjectAdapter();
        RestAssured.baseURI = ReadProperties.getApiUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("token", ReadProperties.getApiKey());

        InputStream stream = this.getClass().getResourceAsStream("/postJsonData/ProjectBody.json");
        String projectToAdd = CharStreams.toString(new InputStreamReader(stream));

        projectCode = projectAdapter.addProject(projectToAdd);
    }

    @Before(value = "@ui", order = 2)
    public void addSuite() throws IOException {
        suiteAdapter = new SuiteAdapter();

        logger.info("Create suit in project with code " + projectCode);
        loggerFile.info("Create suit in project with code " + projectCode);

        InputStream stream = this.getClass().getResourceAsStream("/postJsonData/SuiteBody.json");
        String suiteToAdd = CharStreams.toString(new InputStreamReader(stream));

        suiteAdapter.addSuite(projectCode, suiteToAdd);
    }

    @Before(value = "@ui", order = 3)
    public void setUp(Scenario scenario) {
        logger.info("Starting the browser");
        loggerFile.info("Starting the browser");

        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
    }

    @After(order = 1, value = "@minMaxUiTest")
    public void clearUiTestData() {
        logger.info("Clear project with code " + ProjectStepDefs.projectId);
        loggerFile.info("Clear project with code " + ProjectStepDefs.projectId);

        projectAdapter.deleteProject(ProjectStepDefs.projectId);
    }

    @After(value = "@api or @ui")
    public void clearApiTestData() {
        logger.info("Clear project with code " + projectCode);
        loggerFile.info("Clear project with code " + projectCode);

        projectAdapter.deleteProject(projectCode);
    }

    @After(order = 2, value = "@ui")
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "My screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @After(order = 3, value = "@ui")
    public void tearDown(Scenario scenario) {
        logger.info("Turning off the browser");
        loggerFile.info("Turning off the browser");

        if (driver != null) {
            driver.quit();
        }
    }
}
