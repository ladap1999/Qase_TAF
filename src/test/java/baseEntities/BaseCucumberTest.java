package baseEntities;

import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import services.WaitsService;
import stepDefs.Hook;

public class BaseCucumberTest {
    protected static WebDriver driver;
    protected static WaitsService waitsService;

    protected static String projectCode;
    protected static int suiteId;
    static Logger logger = LogManager.getLogger(Hook.class);
    static Logger loggerFile = LogManager.getLogger("File");

    public static WebDriver getDriver() {
        if (driver != null) {

            return driver;
        } else {
            logger.info("Starting the browser");
            loggerFile.info("Starting the browser");
            return new BrowserFactory().getDriver();
        }
    }

    public static WaitsService getWaitsService() {
        if (waitsService != null) {
            return waitsService;
        } else {
            logger.info("Starting the waits service");
            loggerFile.info("Starting the waits service");
            return new WaitsService(driver);
        }
    }
}
