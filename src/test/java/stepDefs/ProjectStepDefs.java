package stepDefs;

import baseEntities.BaseCucumberTest;
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
    Logger logger = LogManager.getLogger(ProjectApiStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");

    @When("user creates project with name {string} and code {string}")
    public void createProject(String projectName, String projectCode) {
        logger.info("Creating new project with name " + projectName);
        loggerFile.info("Creating new project with name " + projectName);
        projectsPage = new ProjectsPage(driver);
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
        logger.info("Checking if 'Create new project' dialog is opened");
        loggerFile.info("Checking if 'Create new project' dialog page is opened");
        projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.getCreateButton().isDisplayed());
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String message) {
        logger.info("Checking if " + message + " message is displayed");
        loggerFile.info("Checking if " + message + " message is displayed");
        projectsPage = new ProjectsPage(driver);
        System.out.println(projectsPage.getMessage().getText());
        Assert.assertEquals(message, projectsPage.getMessage().getText());

    }

    @Then("Project page is opened")
    public void projectIsDisplayed() {
        logger.info("Checking if project page is opened");
        loggerFile.info("Checking if project page is opened");
        projectPage = new ProjectPage(driver);
        Assert.assertTrue(projectPage.isPageOpened());
    }

    @Then("'{string} repository' is displayed")
    public void nameRepositoryIsDisplayed(String projectCode) {
        logger.info("Checking if '" + projectCode + " repository' is displayed");
        loggerFile.info("Checking if '" + projectCode + " repository' is displayed");
        projectPage = new ProjectPage(driver);
        Assert.assertTrue(projectPage.getRepositoryName().getText().contains(projectCode));
    }
}
