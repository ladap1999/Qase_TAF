package factory;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {
    private WebDriver driver = null;
    Logger logger = LogManager.getLogger(BrowserFactory.class);
    Logger loggerFile = LogManager.getLogger("File");

    public BrowserFactory() {
        switch (ReadProperties.browserName().toLowerCase()) {
            case "chrome":
                DriverManagerType driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ReadProperties.isHeadless());
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--silent");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--lang=en-us");

                driver = new ChromeDriver(chromeOptions);

                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver();
                break;
            default:
                logger.info("Browser " + ReadProperties.browserName() + " is not supported.");
                loggerFile.info("Browser " + ReadProperties.browserName() + " is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
