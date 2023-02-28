package stepDefs;

import adapters.ProjectAdapter;
import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    public ProjectApiStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("user requests all projects")
    public void getAllProjects() {
        logger.info("get all project in ProjectApiStepDefs");
        loggerFile.info("get all project in ProjectApiStepDefs");

        projectAdapter = new ProjectAdapter();
        allProjectsResponse = projectAdapter.getProjects();
    }

    @Then("project with code {string} and title {string} exists")
    public void findDataFromProject(String projectCode, String projectTitle) {
        logger.info("find data from project in ProjectApiStepDefs");
        loggerFile.info("find data from project in ProjectApiStepDefs");

        for (ProjectResponseModel element : allProjectsResponse.getResult().getEntities()) {
            if (element.getCode().equals(projectCode)) {
                Assert.assertEquals(element.getTitle(), projectTitle);
            }
        }
    }
}
