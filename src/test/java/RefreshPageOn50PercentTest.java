import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.http.HttpRequest;
import java.time.Duration;

public class RefreshPageOn50PercentTest {
    private WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void waitForUserTest() {
        WebElement downloadButton = driver.findElement(By.id("cricle-btn"));
        downloadButton.click();
        WebElement percentText = driver.findElement(By.cssSelector("div.percenttext"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElement(percentText,"50%"));
        driver.navigate().refresh();
        WebElement downloadSection = driver.findElement(By.cssSelector("div.panel.panel-primary"));
        Assert.assertTrue(downloadSection.isDisplayed());
    }


    @AfterEach
    void cleanup(){
        driver.close();
    }
}
