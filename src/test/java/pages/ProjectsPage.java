package pages;

import baseEntities.BaseCucumberTest;
import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final String pagePath = "/projects";
    private final By createNewProjectButtonLocator = By.id("createButton");
    private final By elementLocator = By.id("modals");
    private final By selectedProjectLocator = By.xpath("//*[text() = 'FirstApiUIProject']");
    private final By projectNameInputLocator = By.id("project-name");
    private final By projectCodeInputLocator = By.id("project-code");

    @Override
    protected By getPageIdentifier() {
        return createNewProjectButtonLocator;
    }

    public WebElement getCreateNewProjectButton() {
        return BaseCucumberTest.getDriver().findElement(createNewProjectButtonLocator);
    }

    public WebElement getProjectNameInput() {
        return BaseCucumberTest.getDriver().findElement(projectNameInputLocator);
    }

    public WebElement getProjectCodeInput() {
        return BaseCucumberTest.getDriver().findElement(projectCodeInputLocator);
    }

    public WebElement getSelectedProject() {
        return BaseCucumberTest.getWaitsService().waitForExists(selectedProjectLocator);
    }

    public WebElement getCreateButton() {
        WebElement element = BaseCucumberTest.getDriver().findElement(elementLocator);
        return element.findElement(By.cssSelector("[type='submit']"));
    }

    public WebElement getMessage() {
        BaseCucumberTest.getWaitsService().waitForVisibilityBy(By.xpath("//*[@class='Y_SgpC']"));
        return BaseCucumberTest.getDriver().findElement(By.xpath("//*[@class='Y_SgpC']"));
    }
}
