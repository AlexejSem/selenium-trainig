import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Browser {

    private static WebDriver webDriver;
    private static volatile Browser instance;
    private String DOWNLOADED_FILE_PATH = "C:\\Trainig\\qa-automation\\selenium-training\\src\\test\\DownloadedFiles";


    private Browser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", DOWNLOADED_FILE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        webDriver = new ChromeDriver(options);
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

    public WebDriver getWebDriver() {
        return webDriver;
    }
}