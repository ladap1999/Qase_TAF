package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ProjectPage;

public class SuiteStepDefs extends BaseCucumberTest {
    private ProjectPage projectPage;
    Logger logger = LogManager.getLogger(SuiteStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Then("suite with name {string} is presented")
    public void suiteIsPresented(String suiteTitle) {
        logger.info("Find suite with title " + suiteTitle);
        loggerFile.info("Find suite with title " + suiteTitle);

        projectPage = new ProjectPage();

        Assert.assertEquals(projectPage.getSuiteTitle().getText(), suiteTitle);
    }

    @When("user deletes suite entity")
    public void deleteSuite() {
        logger.info("Delete suite entity");
        loggerFile.info("Delete suite entity");

        projectPage = new ProjectPage();
        projectPage.getSuiteSetting().click();
        projectPage.getSuiteDeleting().click();
        projectPage.getSuiteDeleteButtonLocator().submit();
    }

    @Then("message {string} is presented")
    public void messageIsPresented(String deleteMessage) {
        projectPage = new ProjectPage();

        logger.info("delete message is presented");
        loggerFile.info("delete message is presented");

        Assert.assertEquals(projectPage.getSuiteDeleteMessage().getText(), deleteMessage);
    }
}
