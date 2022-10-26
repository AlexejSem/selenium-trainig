import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GoogleWin10EdgeLatestTest {
    private RemoteWebDriver driver;
    private String EXPECTED_RESULT = "Google";
    private static final String URL = "https://oauth-aleksejsemaskevic0-d7bca:6277fef9-d159-429a-aacc-a45dd447144a" +
            "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @BeforeTest
    void setup() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "task_120.1");
        sauceOptions.put("name", "GoogleTitleTest");
        sauceOptions.put("screenResolution", "1920x1200");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, browserOptions);
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
