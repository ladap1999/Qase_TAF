package pages;

import baseEntities.BaseCucumberTest;
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

    @Override
    protected By getPageIdentifier() {
        return createSuiteButtonLocator;
    }

    public void openProjectByUrl(String projectCode) {
        BaseCucumberTest.getDriver().get(ReadProperties.getUiUrl() + pagePath + projectCode);
    }

    public WebElement getRepositoryName() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(repositoryNameLocator);
        return BaseCucumberTest.getDriver().findElement(repositoryNameLocator);
    }

    public WebElement getSuiteTitle() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(suiteTitleLocator);
        return BaseCucumberTest.getDriver().findElement(suiteTitleLocator);
    }

    public WebElement getSuiteSetting() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(suiteSettingLocator);
        return BaseCucumberTest.getDriver().findElement(suiteSettingLocator);
    }

    public WebElement getSuiteDeleting() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(suiteDeleteLocator);
        return BaseCucumberTest.getDriver().findElement(suiteDeleteLocator);
    }

    public WebElement getSuiteDeleteButtonLocator() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(suiteDeleteButtonLocator);
        return BaseCucumberTest.getDriver().findElement(suiteDeleteButtonLocator);
    }

    public WebElement getSuiteDeleteMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(suiteDeletedMessageLocator);
        return BaseCucumberTest.getDriver().findElement(suiteDeletedMessageLocator);
    }

    public WebElement getCreateCaseButton() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(createCaseButtonLocator);
        return BaseCucumberTest.getDriver().findElement(createCaseButtonLocator);
    }

    public WebElement getCaseCreatedMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(caseCreatedMessageLocator);
        return BaseCucumberTest.getDriver().findElement(caseCreatedMessageLocator);
    }
}
