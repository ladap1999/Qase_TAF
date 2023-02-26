package stepDefs.ui;

import baseEntities.BaseUiCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hook {
    private BaseUiCucumberTest baseUiCucumberTest;
    Logger logger = LogManager.getLogger(Hook.class);
    Logger loggerFile = LogManager.getLogger("File");

    public Hook(BaseUiCucumberTest baseCucumberTest) {
        this.baseUiCucumberTest = baseCucumberTest;
    }

    @Before
    public void setUp(Scenario scenario) {
        logger.info("Starting the browser");
        loggerFile.info("Starting the browser");

        baseUiCucumberTest.driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("Turning off the browser");
        loggerFile.info("Turning off the browser");

        if (baseUiCucumberTest.driver != null) {
            baseUiCucumberTest.driver.quit();
        }
    }
}
