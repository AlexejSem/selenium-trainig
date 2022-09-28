import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPageOn50PercentTest {
    private WebDriver driver;
    private final static By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private final static By PERCENTAGE_COUNT = By.cssSelector("div.percenttext");
    private final static By DOWNLOAD_SECTION = By.cssSelector("div.panel.panel-primary");

    @BeforeEach
    void setup() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void waitForUserTest() {
        driver.findElement(DOWNLOAD_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .textToBePresentInElement(driver.findElement(PERCENTAGE_COUNT), "50%"));
        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(DOWNLOAD_SECTION));
    }

    @AfterEach
    void cleanup() {
        driver.close();
    }
}
