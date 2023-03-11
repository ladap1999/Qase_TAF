package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public abstract class BasePage {
    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return BaseCucumberTest.getWaitsService().waitForVisibilityBy(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        BaseCucumberTest.getDriver().get(ReadProperties.getUiUrl() + pagePath);
    }
}
