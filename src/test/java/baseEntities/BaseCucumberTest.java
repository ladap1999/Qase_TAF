package baseEntities;

import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public class BaseCucumberTest {
    protected Gson gson;
    protected static WebDriver driver;
    protected static WaitsService waitsService;
}
