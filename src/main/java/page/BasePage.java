package page;

import browser.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = Driver.getInstance().getDriver();
    }
}
