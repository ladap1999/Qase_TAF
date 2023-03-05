package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ProjectPage;
import pages.ProjectsPage;

public class ProjectStepDefs extends BaseCucumberTest {
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    protected static String projectId;
    Logger logger = LogManager.getLogger(ProjectStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");

    @When("user creates project with name {string} and code {string}")
    public void createProject(String projectName, String projectCode) {
        projectId = projectCode;
        projectsPage = new ProjectsPage(driver);

        logger.info("Creating new project with name " + projectName);
        loggerFile.info("Creating new project with name " + projectName);

        projectsPage.getCreateNewProjectButton().click();
        projectsPage.getProjectNameInput().sendKeys(projectName);
        projectsPage.getProjectCodeInput().sendKeys(projectCode);
        projectsPage.getCreateButton().click();
    }

    @Then("Projects Page is opened")
    public void projectsPageIsOpened() {
        logger.info("Checking if projects page is opened");
        loggerFile.info("Checking if projects page is opened");

        Assert.assertTrue(projectsPage.isPageOpened());
    }

    @Then("'Create new project' dialog is still opened")
    public void createProjectDialogIsOpened() {
        projectsPage = new ProjectsPage(driver);

        logger.info("Checking if 'Create new project' dialog is opened");
        loggerFile.info("Checking if 'Create new project' dialog page is opened");

        Assert.assertTrue(projectsPage.getCreateButton().isDisplayed());
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String message) {
        projectsPage = new ProjectsPage(driver);

        logger.info("Checking if " + message + " message is displayed");
        loggerFile.info("Checking if " + message + " message is displayed");

        Assert.assertEquals(message, projectsPage.getMessage().getText());
    }

    @Then("Project page is opened")
    public void projectIsDisplayed() {
        projectPage = new ProjectPage(driver);

        logger.info("Checking if project page is opened");
        loggerFile.info("Checking if project page is opened");

        Assert.assertTrue(projectPage.isPageOpened());
    }

    @Then("'{string} repository' is displayed")
    public void nameRepositoryIsDisplayed(String projectCode) {
        projectPage = new ProjectPage(driver);

        logger.info("Checking if '" + projectCode + " repository' is displayed");
        loggerFile.info("Checking if '" + projectCode + " repository' is displayed");

        Assert.assertTrue(projectPage.getRepositoryName().getText().contains(projectCode));
    }

    @When("user navigates to ProjectPage")
    public void navigateToProjectPage() {
        projectsPage = new ProjectsPage(driver);

        logger.info("Navigate to Selected Project");
        loggerFile.info("Navigate to Selected Project");

        projectsPage.getSelectedProject().click();
    }

    @Given("page of existed project is opened by url")
    public void openProjectPage() {
        logger.info("opening Project page");
        loggerFile.info("opening Project page");

        projectPage = new ProjectPage(driver);
        projectPage.openProjectByUrl(projectCode);
    }
}
