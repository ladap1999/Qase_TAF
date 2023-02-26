package baseEntities;

import org.openqa.selenium.WebDriver;

public class BaseUiCucumberTest {
    public static WebDriver driver;

    public BaseUiCucumberTest(WebDriver driver) {
        this.driver = driver;
    }
}