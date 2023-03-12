package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadFiles;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CreateCasePage;
import pages.ProjectPage;

import java.io.IOException;

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

        projectPage = new ProjectPage();
        createCasePage = new CreateCasePage();

        projectPage.getCreateCaseButton().click();

        createCasePage.getCaseNameInput().sendKeys("For Test");
        createCasePage.getSaveButton().click();
    }

    @Then("message {string} is shown")
    public void checkMessage(String message) {
        logger.info("checking message");
        loggerFile.info("checking message");

        projectPage = new ProjectPage();
        Assert.assertEquals(projectPage.getCaseCreatedMessage().getText(), message);
    }

    @When("user cancels creation of test case")
    public void cancelCreationOfTestCase() {
        logger.info("call dialog window");
        loggerFile.info("call dialog window");

        projectPage = new ProjectPage();
        createCasePage = new CreateCasePage();

        projectPage.getCreateCaseButton().click();
        createCasePage.getCaseNameInput().sendKeys("For Test");
        createCasePage.getCancelButton().click();
    }

    @Then("dialog window with special elements is presented")
    public void dialogWindowIsPresented() throws IOException {
        logger.info("element CloseFormButton is shown");
        loggerFile.info("element CloseFormButton is shown");

        createCasePage = new CreateCasePage();
        Assert.assertTrue(createCasePage.getCloseFormButton().isDisplayed());
        Assert.assertEquals(createCasePage.getFormText().getText(), ReadFiles.readFileContent("WindowMessageData"));
        Assert.assertTrue(createCasePage.getInformMessage().isDisplayed());
        Assert.assertTrue(createCasePage.getCancelFormButton().isEnabled());
    }

    @When("user starts creating case and adds attachment")
    public void userStartsCreatingCaseAndAddsAttachment() {
        logger.info("adding attachment to new case");
        loggerFile.info("adding attachment to new case");

        projectPage = new ProjectPage();
        createCasePage = new CreateCasePage();

        String pathToFile = CaseStepDefs.class.getClassLoader().getResource("upload.txt").getPath().substring(1);

        projectPage.getCreateCaseButton().click();
        createCasePage.getAddAttachment().click();

        waitsService.waitForExists(createCasePage.getUploadAttachmentInputLocator()).sendKeys(pathToFile);
    }

    @Then("attachment is added")
    public void attachmentIsAdded() {
        logger.info("checking attachment");
        loggerFile.info("checking attachment");

        createCasePage = new CreateCasePage();
        Assert.assertEquals(waitsService.waitForVisibilityBy(createCasePage.getAttachedFileLocator()).getText(),"upload.txt");
    }

    @When("user starts creating case and enters too long name")
    public void userStartsCreatingCaseAndEntersLongName() throws IOException {
        logger.info("sending too long name to new case");
        loggerFile.info("sending too long name to new case");

        projectPage = new ProjectPage();
        createCasePage = new CreateCasePage();

        projectPage.getCreateCaseButton().click();

        createCasePage.getCaseNameInput().sendKeys(ReadFiles.readFileContent("256.txt"));
        createCasePage.getSaveButton().click();
    }

    @Then("{string} message appears")
    public void messageAppears(String message) {
        createCasePage = new CreateCasePage();
        Assert.assertEquals(createCasePage.getAlertMessage().getText(), message);
    }

    @Then("validation {string} is presented")
    public void messageIsPresented(String message) {
        createCasePage = new CreateCasePage();
        Assert.assertEquals(createCasePage.getValidationMessage().getText(), message);
    }
}
