package pages;

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

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return createNewProjectButtonLocator;
    }

    public WebElement getCreateNewProjectButton() {
        return driver.findElement(createNewProjectButtonLocator);
    }

    public WebElement getProjectNameInput() {
        return driver.findElement(projectNameInputLocator);
    }

    public WebElement getProjectCodeInput() {
        return driver.findElement(projectCodeInputLocator);
    }

    public WebElement getSelectedProject() {
        return waitsService.waitForExists(selectedProjectLocator);
    }

    public WebElement getCreateButton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[type='submit']"));
    }

    public WebElement getMessage() {
        waitsService.waitForVisibilityBy(By.xpath("//*[@class='Y_SgpC']"));
        return driver.findElement(By.xpath("//*[@class='Y_SgpC']"));
    }
}
