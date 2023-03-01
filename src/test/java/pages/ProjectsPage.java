package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private String pagePath = "/projects";
    private final By createNewProjectButtonLocator = By.id("createButton");
    private final By elementLocator = By.id("modals"); //parent for 'Create new project' dialog
    private final By projectNameInputLocator = By.id("project-name");
    private final By projectCodeInputLocator = By.id("project-code");
    private final By projectDescriptionInputLocator = By.id("description-area");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return createNewProjectButtonLocator;
    }

    public WebElement getCreateNewProjectButton() { return driver.findElement(createNewProjectButtonLocator);}

    public WebElement getProjectNameInput() { return driver.findElement(projectNameInputLocator);}

    public WebElement getProjectCodeInput() { return driver.findElement(projectCodeInputLocator);}

    public WebElement getProjectDescriptionInput() { return driver.findElement(projectDescriptionInputLocator);}

    public WebElement getCancelButton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[type='button']"));
    }

    public WebElement getCreateButton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[type='submit']"));
    }

    public WebElement getMessage() {
        WebElement element = driver.findElement(elementLocator);
        waitsService.waitForVisibilityBy(By.xpath("//*[@class='Y_SgpC']"));
        return driver.findElement(By.xpath("//*[@class='Y_SgpC']"));
    }

    public WebElement getProjectAccessPrivateRadiobutton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[value='private']"));
    }

    public WebElement getProjectAccessPublicRadiobutton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[value='public']"));
    }

    public WebElement getMemberAccessAllRadiobutton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[value='all']"));
    }

    public WebElement getMemberAccessGroupRadiobutton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[value='group']"));
    }

    public WebElement getMemberAccessDontAddRadiobutton() {
        WebElement element = driver.findElement(elementLocator);
        return element.findElement(By.cssSelector("[value='none']"));
    }
}
