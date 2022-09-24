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

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void waitForUserTest(){
        WebElement getNewUserButton = driver.findElement(By.cssSelector("button.btn"));
        getNewUserButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfNestedElementLocatedBy(By.cssSelector("div#loading"),By.cssSelector("div#loading > br:nth-child(2)")));
    }

    @AfterEach
    void cleanup(){
        driver.close();
    }
}
