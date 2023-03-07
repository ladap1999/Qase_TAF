package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCasePage extends BasePage {

    private String pagePath = "/case/{code}/create/{id}";
    private final By createCaseLocator = By.xpath("//*[text() = 'Create test case']");
    private final By caseNameInputLocator = By.id("title");
    private final By saveButtonLocator = By.xpath("//*[text() = 'Save']");
    private final By cancelButtonLocator = By.xpath("//*[text() = 'Cancel']");
    private final By closeFormButtonLocator = By.xpath("//*[text() = 'Close form']");
    private final By cancelFormButtonLocator = By.xpath("//*[text() = 'Cancel']");
    private final By informMessageLocator = By.cssSelector(".W_JRzn");
    private final By formTextLocator = By.xpath("//*[text() = 'All unsaved information related to this test case will be lost. Do you want to proceed?']");
    private final By addAttachmentLocator = By.xpath("//*[text() = 'Add attachment']");

    public CreateCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return createCaseLocator;
    }

    public WebElement getCaseNameInput() {
        waitsService.waitForVisibilityBy(caseNameInputLocator);
        return driver.findElement(caseNameInputLocator);
    }

    public WebElement getAddAttachment() {
        return driver.findElement(addAttachmentLocator);
    }

    public WebElement getSaveButton() {
        return driver.findElement(saveButtonLocator);
    }

    public WebElement getCancelButton() {
        waitsService.waitForVisibilityBy(cancelButtonLocator);
        return driver.findElement(cancelButtonLocator);
    }

    public WebElement getCloseFormButton() {
        waitsService.waitForVisibilityBy(closeFormButtonLocator);
        return driver.findElement(closeFormButtonLocator);
    }

    public WebElement getCancelFormButton() {
        waitsService.waitForVisibilityBy(cancelFormButtonLocator);
        return driver.findElement(cancelFormButtonLocator);
    }

    public WebElement getFormTextLocator() {
        waitsService.waitForVisibilityBy(formTextLocator);
        return driver.findElement(formTextLocator);
    }

    public WebElement getInformMassageLocator() {
        waitsService.waitForVisibilityBy(informMessageLocator);
        return driver.findElement(informMessageLocator);
    }
}
