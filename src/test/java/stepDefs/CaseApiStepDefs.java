package stepDefs;

import adapters.CaseAdapter;
import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Case;
import models.apiResponseModels.CaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CaseApiStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private CaseAdapter caseAdapter;
    Logger logger = LogManager.getLogger(CaseApiStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");
    private Response getCaseResponse;
    private int caseID;
    private Case actualCase;

    public CaseApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("case with name {string} is created")
    public void createCase(String caseName) {
        caseAdapter = new CaseAdapter();

        Case expectedCase = Case.builder()
                .caseName(caseName)
                .description("for test")
                .build();

        caseID = caseAdapter.addCase(expectedCase, projectCode);
    }

    @Given("user creates case with name {string} in created suite")
    public void createCaseInSuite(String caseName) {
        caseAdapter = new CaseAdapter();

        Case expectedCase = Case.builder()
                .caseName(caseName)
                .description("for test")
                .suiteID(suiteId)
                .build();

        caseID = caseAdapter.addCase(expectedCase, projectCode);
    }

    @When("user requests created case")
    public void getCreatedCase() {
        caseAdapter = new CaseAdapter();
        actualCase = new Case();

        getCaseResponse = caseAdapter.getCase(projectCode, caseID);
        actualCase = getCaseResponse.as(CaseResponse.class, ObjectMapperType.GSON).getResult();
    }

    @Then("case name is {string}")
    public void checkCaseName(String caseName) {
        logger.info("checking case name");
        loggerFile.info("checking case name");

        Assert.assertEquals(actualCase.getCaseName(), caseName);
    }

    @Then("case with name {string} is in suite")
    public void checkCaseSuiteID(String caseName) {
        logger.info("checking case name");
        loggerFile.info("checking case name");

        getCreatedCase();
        Assert.assertEquals(actualCase.getCaseName(), caseName);
        Assert.assertEquals(actualCase.getSuiteID(), suiteId);
    }
}
