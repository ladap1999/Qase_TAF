package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectsPage;

public class UserStepDefs extends BaseCucumberTest {
    private LoginPage loginPage;

    @Given("user logged in")
    public ProjectsPage login() {
        loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        return new ProjectsPage(driver);
    }

    @When("user {string} with password {string} logged in")
    public LoginPage loginIncorrect(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        return loginPage;
    }

    @Then("Login page is opened")
    public void loginPageIsOpened() {
        Assert.assertTrue(loginPage.isPageOpened());
    }
}
