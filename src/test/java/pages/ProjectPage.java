package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private final String pagePath = "/project/";
    private final By createSuiteButtonLocator = By.id("create-suite-button");
    private final By createCaseButtonLocator = By.id("create-case-button");
    private final By repositoryNameLocator = By.xpath("//h1");
    private final By suiteTitleLocator = By.xpath("//*[@title = 'SuiteFromPostResponse']");
    private final By caseCreatedMessageLocator = By.xpath("//*[text() = 'Test case was created successfully!']");
    private final By suiteSettingLocator = By.xpath("//*[@class = 'fa fa-ellipsis-h']");
    private final By suiteDeleteLocator = By.xpath("//*[@class = 'D6EIXH rzizJk']");
    private final By suiteDeleteButtonLocator = By.xpath("//*[@type = 'submit']");
    private final By suiteDeletedMessageLocator = By.xpath("//*[@role = 'alert']");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return createSuiteButtonLocator;
    }

    public void openProjectByUrl(String projectCode) {
        driver.get(ReadProperties.getUiUrl() + pagePath + projectCode);
    }

    public WebElement getRepositoryName() {
        waitsService.waitForVisibilityBy(repositoryNameLocator);
        return driver.findElement(repositoryNameLocator);
    }

    public WebElement getSuiteTitle() {
        waitsService.waitForVisibilityBy(suiteTitleLocator);
        return driver.findElement(suiteTitleLocator);
    }

    public WebElement getSuiteSetting() {
        waitsService.waitForVisibilityBy(suiteSettingLocator);
        return driver.findElement(suiteSettingLocator);
    }

    public WebElement getSuiteDeleting() {
        waitsService.waitForVisibilityBy(suiteDeleteLocator);
        return driver.findElement(suiteDeleteLocator);
    }

    public WebElement getSuiteDeleteButtonLocator() {
        waitsService.waitForVisibilityBy(suiteDeleteButtonLocator);
        return driver.findElement(suiteDeleteButtonLocator);
    }

    public WebElement getSuiteDeleteMessage() {
        waitsService.waitForVisibilityBy(suiteDeletedMessageLocator);
        return driver.findElement(suiteDeletedMessageLocator);
    }

    public WebElement getCreateSuiteButton() {
        waitsService.waitForVisibilityBy(createSuiteButtonLocator);
        return driver.findElement(createSuiteButtonLocator);
    }

    public WebElement getCreateCaseButton() {
        waitsService.waitForVisibilityBy(createCaseButtonLocator);
        return driver.findElement(createCaseButtonLocator);
    }

    public WebElement getcaseCreatedMessage() {
        waitsService.waitForVisibilityBy(caseCreatedMessageLocator);
        return driver.findElement(caseCreatedMessageLocator);
    }
}
