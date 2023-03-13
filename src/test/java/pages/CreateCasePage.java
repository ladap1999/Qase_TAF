package pages;

import baseEntities.BaseCucumberTest;
import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCasePage extends BasePage {
    private final String pagePath = "/case/{code}/create/{id}";
    private final By createCaseLocator = By.xpath("//*[text() = 'Create test case']");
    private final By caseNameInputLocator = By.id("title");
    private final By saveButtonLocator = By.xpath("//*[text() = 'Save']");
    private final By cancelButtonLocator = By.xpath("//*[text() = 'Cancel']");
    private final By closeFormButtonLocator = By.xpath("//*[text() = 'Close form']");
    private final By cancelFormButtonLocator = By.xpath("//*[text() = 'Cancel']");
    private final By informMessageLocator = By.cssSelector(".W_JRzn");
    private final By formTextLocator = By.xpath("//*[@class = 'PeaEvB']/child::p");
    private final By addAttachmentButtonLocator = By.xpath("//*[text() = 'Add attachment']");
    private final By uploadAttachmentInputLocator= By.cssSelector("input[type='file']");
    private final By attachedFileLocator= By.cssSelector(".Eq3UUR");
    private final By alertMessageLocator = By.cssSelector(".OL6rtE");
    private final By validationMessageLocator = By.xpath("//*[@id = 'titleGroup']/*[@class = 'form-control-feedback']");

    @Override
    protected By getPageIdentifier() {
        return createCaseLocator;
    }

    public WebElement getCaseNameInput() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(caseNameInputLocator);
        return BaseCucumberTest.getDriver().findElement(caseNameInputLocator);
    }

    public By getUploadAttachmentInputLocator() {
        return uploadAttachmentInputLocator;
    }

    public By getAttachedFileLocator() {
        return attachedFileLocator;
    }

    public WebElement getAddAttachment() {
        return BaseCucumberTest.getDriver().findElement(addAttachmentButtonLocator);
    }

    public WebElement getSaveButton() {
        return BaseCucumberTest.getDriver().findElement(saveButtonLocator);
    }

    public WebElement getCancelButton() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(cancelButtonLocator);
        return BaseCucumberTest.getDriver().findElement(cancelButtonLocator);
    }

    public WebElement getCloseFormButton() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(closeFormButtonLocator);
        return BaseCucumberTest.getDriver().findElement(closeFormButtonLocator);
    }

    public WebElement getCancelFormButton() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(cancelFormButtonLocator);
        return BaseCucumberTest.getDriver().findElement(cancelFormButtonLocator);
    }

    public WebElement getFormText() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(formTextLocator);
        return BaseCucumberTest.getDriver().findElement(formTextLocator);
    }

    public WebElement getInformMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(informMessageLocator);
        return BaseCucumberTest.getDriver().findElement(informMessageLocator);
    }

    public WebElement getAlertMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(alertMessageLocator);
        return BaseCucumberTest.getDriver().findElement(alertMessageLocator);
    }

    public WebElement getValidationMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(validationMessageLocator);
        return BaseCucumberTest.getDriver().findElement(validationMessageLocator);
    }
}
