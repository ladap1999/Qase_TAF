package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectsPage;

public class UserStepDefs extends BaseCucumberTest {
    private LoginPage loginPage;
    Logger logger = LogManager.getLogger(UserStepDefs.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Given("user logged in")
    public ProjectsPage login() {
        loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        logger.info("user successfully logged in");
        loggerFile.info("user successfully logged in");

        return new ProjectsPage(driver);
    }

    @When("user {string} with password {string} logged in")
    public LoginPage loginIncorrect(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        logger.info("user cannot log in, credentials are wrong");
        loggerFile.info("user cannot log in, credentials are wrong");

        return loginPage;
    }

    @Then("Login page is opened")
    public void loginPageIsOpened() {
        Assert.assertTrue(loginPage.isPageOpened());
    }
}
