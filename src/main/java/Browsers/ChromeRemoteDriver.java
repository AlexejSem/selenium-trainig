package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ChromeRemoteDriver {

    private static final String URL = "https://oauth-aleksejsemaskevic0-d7bca:6277fef9-d159-429a-aacc-a45dd447144a" +
            "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private RemoteWebDriver driver;

    public WebDriver getRemoteWebDriver() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, browserOptions);
        return driver;
    }
}
