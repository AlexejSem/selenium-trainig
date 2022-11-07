package Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxBrowser {

    private static WebDriver webDriver;
    private static volatile FireFoxBrowser instance = null;

    private FireFoxBrowser() {
        WebDriverManager.getInstance(FirefoxDriver.class).setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static FireFoxBrowser getInstance() {
        FireFoxBrowser localInstance = instance;
        if (localInstance == null) {
            synchronized (FireFoxBrowser.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FireFoxBrowser();
                }
            }
        }
        return localInstance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}