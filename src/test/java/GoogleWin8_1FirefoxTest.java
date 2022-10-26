import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleWin8_1FirefoxTest {
    private RemoteWebDriver driver;
    private String EXPECTED_RESULT = "Google";
    private static final String URL = "https://oauth-aleksejsemaskevic0-d7bca:6277fef9-d159-429a-aacc-a45dd447144a" +
            "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @BeforeTest
    void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "firefox");
        caps.setCapability("platform", "Windows 8.1");
        caps.setCapability("version", "39");
        caps.setCapability("screenResolution", "1920x1200");
        caps.setCapability("build", "task_120.2");
        caps.setCapability("name", "GoggleTitleTest");

        java.net.URL url = new URL(URL);
        driver = new RemoteWebDriver(url, caps);
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

