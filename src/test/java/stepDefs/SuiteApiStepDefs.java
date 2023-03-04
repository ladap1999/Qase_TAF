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
    Response rs;
    String projectCode;
    int suiteID;
    Suite actualSuite;

    public SuiteApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("suite with name {string} is created")
    public void createSuite(String suiteName) {
        suiteAdapter = new SuiteAdapter();

        projectCode = "FIRST";
        Suite expectedSuite = Suite.builder()
                .suiteName(suiteName)
                .description("for test")
                .build();

        suiteID = suiteAdapter.addSuite(projectCode, expectedSuite);
    }

    @When("user requests created suite")
    public void getCreatedCase() {
        suiteAdapter = new SuiteAdapter();
        actualSuite = new Suite();

        rs = suiteAdapter.getSuite(projectCode, suiteID);
        actualSuite = rs.as(SuiteResponse.class, ObjectMapperType.GSON).getResult();
    }

    @Then("suite name is {string}")
    public void checkSuiteName(String suiteName) {
        logger.info("checking case name");
        loggerFile.info("checking case name");
        Assert.assertEquals(actualSuite.getSuiteName(), suiteName);
    }
}
