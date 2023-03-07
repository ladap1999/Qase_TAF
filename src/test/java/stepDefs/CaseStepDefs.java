package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CreateCasePage;
import pages.ProjectPage;

public class CaseStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    Logger logger = LogManager.getLogger(CaseStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");
    private ProjectPage projectPage;
    private CreateCasePage createCasePage;

    public CaseStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("user creates case")
    public void createCase() {
        logger.info("creating test case");
        loggerFile.info("creating test case");

        projectPage = new ProjectPage(driver);
        createCasePage = new CreateCasePage(driver);

        projectPage.getCreateCaseButton().click();

        createCasePage.getCaseNameInput().sendKeys("For Test");
        createCasePage.getSaveButton().click();
    }

    @Then("message {string} is shown")
    public void checkMessage(String message) {
        logger.info("checking message");
        loggerFile.info("checking message");

        projectPage = new ProjectPage(driver);
        Assert.assertEquals(projectPage.getcaseCreatedMessage().getText(), message);
    }

    @When("user cancels creation of test case")
    public void cancelCreationOfTestCase() {
        logger.info("call dialog window");
        loggerFile.info("call dialog window");

        projectPage = new ProjectPage(driver);
        createCasePage = new CreateCasePage(driver);

        projectPage.getCreateCaseButton().click();
        createCasePage.getCaseNameInput().sendKeys("For Test");
        createCasePage.getCancelButton().click();
    }

    @Then("dialog window with special elements is presented")
    public void dialogWindowIsPresented() {
        logger.info("element CloseFormButton is shown");
        loggerFile.info("element CloseFormButton is shown");

        createCasePage = new CreateCasePage(driver);
        Assert.assertTrue(createCasePage.getCloseFormButton().isDisplayed());
        Assert.assertTrue(createCasePage.getFormTextLocator().isDisplayed());
        Assert.assertTrue(createCasePage.getInformMassageLocator().isDisplayed());
        Assert.assertTrue(createCasePage.getCancelFormButton().isEnabled());
    }
}
