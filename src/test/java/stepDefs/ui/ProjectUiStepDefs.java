package stepDefs.ui;

import baseEntities.BaseUiCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectUiStepDefs extends BaseUiCucumberTest {
    private ProjectsPage projectsPage;

    public ProjectUiStepDefs(WebDriver driver) {
        super(driver);
    }

    @When("create project with name {string} and code {string}")
    public void createProject(String projectName, String projectCode) {
        projectsPage.getProjectNameInput().sendKeys(projectName);
        projectsPage.getProjectCodeInput().sendKeys(projectCode);
        projectsPage.getCreateButton().click();
    }

    @Then("Projects Page is opened")
    public void projectsPageIsOpened() {
        Assert.assertTrue(projectsPage.isPageOpened());
    }

    @Then("Project with name {string} is displayed")
    public void projectIsDisplayed(String projectName) {

    }


}
