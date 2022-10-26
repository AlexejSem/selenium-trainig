import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {
    private RemoteWebDriver driver;
    private String EXPECTED_RESULT = "Google";

    @BeforeTest
    void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    }

    @Test
    void GoggleTitleTest() {

        driver.get("http://www.google.com");
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, EXPECTED_RESULT);
    }

    @AfterTest
    void cleanup() {
        driver.quit();
    }
}
