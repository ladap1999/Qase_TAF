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
        loginPage = new LoginPage();
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        logger.info("user successfully logged in");
        loggerFile.info("user successfully logged in");

        return new ProjectsPage();
    }

    @When("user inputs incorrect login {string}")
    @When("user inputs non-existent login {string}")
    public void incorrectLogin(String login) {
        logger.info("user logins in with incorrect data");
        loggerFile.info("user logins in with incorrect data");

        loginPage = new LoginPage();
        loginPage.login(login, ReadProperties.password());
    }

    @Then("validation alert {string} is presented")
    public void validationAlertIsPresented(String message) {
        loginPage = new LoginPage();
        logger.info("message '" + message + "' is presented");
        loggerFile.info("message '" + message + "' is presented");

        Assert.assertEquals(loginPage.getEmailInput().getAttribute("validationMessage"), message);
    }
}
