package stepDefs;

import adapters.ProjectAdapter;
import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.apiResponseModels.AllProjectsResponseModel;
import models.apiResponseModels.ProjectResponseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class ProjectApiStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private ProjectAdapter projectAdapter;
    Logger logger = LogManager.getLogger(ProjectApiStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");
    AllProjectsResponseModel allProjectsResponse;
    Response getProjectResponse;

    public ProjectApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("user requests all projects")
    public void getAllProjects() {
        projectAdapter = new ProjectAdapter();

        logger.info("get all project in ProjectApiStepDefs");
        loggerFile.info("get all project in ProjectApiStepDefs");

        allProjectsResponse = projectAdapter.getProjects();
    }

    @Then("project with code {string} and title {string} exists")
    public void findDataFromProject(String projectCode, String projectTitle) throws NullPointerException {
        logger.info("find data from project in ProjectApiStepDefs");
        loggerFile.info("find data from project in ProjectApiStepDefs");

        ProjectResponseModel actualProject = allProjectsResponse.getResult().getEntities()
                .stream()
                .filter(el -> el.getCode().equals(projectCode))
                .findAny()
                .orElse(null);

        Assert.assertNotNull(actualProject);
        Assert.assertEquals(actualProject.getTitle(), projectTitle);
    }

    @When("user requests project with code {string}")
    public void getProjectWithCode(String projectCode) {
        projectAdapter = new ProjectAdapter();
        getProjectResponse = projectAdapter.getProject(projectCode);
    }

    @Then("status code of get project response is {int}")
    public void statusCodeIs(int expectedStatusCode) {
        Assert.assertEquals(getProjectResponse.statusCode(), expectedStatusCode);
    }
}
