package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ProjectPage;

public class SuiteStepDefs extends BaseCucumberTest {
    private ProjectPage projectPage;
    Logger logger = LogManager.getLogger(SuiteStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Then("suite with name {string} is presented")
    public void isSuitePresented(String suiteTitle) {
        logger.info("Find suite with title " + suiteTitle);
        loggerFile.info("Find suite with title " + suiteTitle);

        projectPage = new ProjectPage(driver);

        Assert.assertEquals(projectPage.getSuiteTitle().getText(), suiteTitle);
    }
}
