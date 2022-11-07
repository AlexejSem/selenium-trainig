package Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {

    private static WebDriver webDriver;
    private static volatile ChromeBrowser instance = null;

    private ChromeBrowser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static ChromeBrowser getInstance() {
        ChromeBrowser localInstance = instance;
        if (localInstance == null) {
            synchronized (ChromeBrowser.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ChromeBrowser();
                }
            }
        }
        return localInstance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}