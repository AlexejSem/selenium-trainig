package browser;

import helper.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.time.Duration;

public class Driver {

    private static final String BROWSER = StringUtils.defaultString(System.getProperty("browser"), "chrome");
    private static final String REMOTE_URL = StringUtils.defaultString(System.getProperty("remote"), "local");
    private static volatile Driver instance = null;
    private WebDriver driver;

    private Driver() {
        if (REMOTE_URL.contains("local")) {
            setLocalDriver();
        }
        setRemoteDriver();
    }

    public static Driver getInstance() {
        Driver localInstance = instance;
        if (localInstance == null) {
            synchronized (Driver.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Driver();
                }
            }
        }
        return localInstance;
    }

    private void setLocalDriver() {
        switch (BROWSER) {
            case "chrome" -> {
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            }
            case "forefox" -> {
                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            }
        }
    }

    @SneakyThrows
    private void setRemoteDriver() {
        final Capabilities capabilities = getCapabilities();
        String url;
        if (REMOTE_URL.contains("saucelabs")) {
            url = Constants.SAUCE_URL;
        } else {
            url = Constants.GRID_URL;
        }
        driver = new RemoteWebDriver(new URL(url), capabilities);
    }

    private Capabilities getCapabilities() {
        switch (BROWSER) {
            case "crome" -> {
                ChromeOptions option = new ChromeOptions();
                option.setCapability("os", "Windows");
                return option;
            }
            case "firefox" -> {
                FirefoxOptions option = new FirefoxOptions();
                option.setCapability("os", "Windows");
                return option;
            }
        }
        return null;
    }

    public WebDriver getDriver() {
        return driver;
    }
}