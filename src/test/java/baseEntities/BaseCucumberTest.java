package baseEntities;

import org.openqa.selenium.WebDriver;
import services.WaitsService;

public class BaseCucumberTest {
    protected static WebDriver driver;
    protected static WaitsService waitsService;

    protected static String projectCode;
    protected static int suiteId;
}
