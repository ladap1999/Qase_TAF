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
}
