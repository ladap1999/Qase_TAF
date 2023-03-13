package pages;

import baseEntities.BaseCucumberTest;
import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final String pagePath = "/login";
    private final By emailInputLocator = By.id("inputEmail");
    private final By passwordInputLocator = By.id("inputPassword");
    private final By logInButtonLocator = By.id("btnLogin");

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public WebElement getEmailInput() { return BaseCucumberTest.getDriver().findElement(emailInputLocator);}
    public WebElement getPasswordInput() { return BaseCucumberTest.getDriver().findElement(passwordInputLocator);}
    public WebElement getLoginButton() { return BaseCucumberTest.getDriver().findElement(logInButtonLocator);}

    public void login(String email, String password) {
        openPageByUrl(pagePath);
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}
