import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitForUserTest {

    private WebDriver driver;
    private final static By NEW_USER_BUTTON = By.cssSelector("button.btn");
    private final static By USER_IMAGE = By.cssSelector("img[src*='https://randomuser.me/api/");


    @BeforeEach
    void setup() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void waitForUserTest() {
        driver.findElement(NEW_USER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(USER_IMAGE));
    }

    @AfterEach
    void cleanup() {
        driver.close();
    }
}
