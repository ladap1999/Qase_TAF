package stepDefs;

import adapters.SuiteAdapter;
import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Suite;
import models.apiResponseModels.SuiteResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SuiteApiStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private SuiteAdapter suiteAdapter;
    Logger logger = LogManager.getLogger(SuiteApiStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");
    private Response getSuiteResponse;
    private Response getSuitesResponse;
    private Suite actualSuite;

    public SuiteApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("suite with name {string} is created")
    public void createSuite(String suiteName) {
        suiteAdapter = new SuiteAdapter();

        Suite expectedSuite = Suite.builder()
                .suiteName(suiteName)
                .description("for test")
                .build();

        suiteId = suiteAdapter.addSuite(Hook.projectCode, expectedSuite);
    }

    @When("user requests created suite")
    public void getCreatedSuite() {
        suiteAdapter = new SuiteAdapter();
        actualSuite = new Suite();

        getSuiteResponse = suiteAdapter.getSuite(Hook.projectCode, suiteId);
        actualSuite = getSuiteResponse.as(SuiteResponse.class, ObjectMapperType.GSON).getResult();
    }

    @Then("suite name is {string}")
    public void checkSuiteName(String suiteName) {
        logger.info("checking case name");
        loggerFile.info("checking case name");
        Assert.assertEquals(actualSuite.getSuiteName(), suiteName);
    }

    @When("user requests all suites from project with code {string}")
    public void getSuitesFromSelectedProject(String projectCode) {
        suiteAdapter = new SuiteAdapter();
        getSuitesResponse = suiteAdapter.getSuites(projectCode);
    }

    @Then("status code of get suites response is {int}")
    public void statusCodeIs(int expectedStatusCode) {
        Assert.assertEquals(getSuitesResponse.statusCode(), expectedStatusCode);
    }
}
