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
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CaseApiStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private CaseAdapter caseAdapter;
    Logger logger = LogManager.getLogger(CaseApiStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");
    Response rs;
    String projectCode;
    int caseID;
    Case actualCase;
    Project project;

    public CaseApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("case with name {string} is created")
    public void createCase(String caseName) {
        caseAdapter = new CaseAdapter();

//        String jsonProject = Files.readString(Paths.get("src/test/resources/postJsonData/ProjectBody.json"));
//        project = new Project();
//        project = gson.fromJson(jsonProject, Project.class);
//        projectCode = project.getProjectCode();

        projectCode = "FIRST";

        Case expectedCase = Case.builder()
                .caseName(caseName)
                .description("for test")
                .severity(1)
                .build();

        caseID = caseAdapter.addCase(expectedCase, projectCode);
    }

    @When("user requests created case")
    public void getCreatedCase() {
        caseAdapter = new CaseAdapter();
        actualCase = new Case();

        rs = caseAdapter.getCase(projectCode, caseID);
        actualCase = rs.as(CaseResponse.class, ObjectMapperType.GSON).getResult();
    }

    @Then("case name is {string}")
    public void statusCodeIs(String caseName) {
        logger.info("checking case name");
        loggerFile.info("checking case name");
        Assert.assertEquals(actualCase.getCaseName(), caseName);
    }
}
