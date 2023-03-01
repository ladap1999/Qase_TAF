package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private String pagePath = "/login";
    private final By emailInputLocator = By.id("inputEmail");
    private final By passwordInputLocator = By.id("inputPassword");
    private final By logInButtonLocator = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public By getLogInButtonLocator() {
        return logInButtonLocator;
    }

    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPasswordInput() { return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton() { return driver.findElement(logInButtonLocator);}

    public void login(String email, String password) {
        openPageByUrl(pagePath);
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}
