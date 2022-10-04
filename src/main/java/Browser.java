import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser {

    private static WebDriver webDriver;
    private static volatile Browser instance;

    private Browser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static Browser getInstance() {
        Browser localInstance = instance;
        if (localInstance == null) {
            synchronized (Browser.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Browser();
                }
            }
        }
        return localInstance;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}