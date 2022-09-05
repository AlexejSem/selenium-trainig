import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    private WebDriver webDriver;

    @BeforeEach
    void setWebDriver(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://mail.yandex.com/");
    }

    @Test
    void loginToYandexMailTest() throws InterruptedException {
        WebElement loginButton = webDriver.findElement(By.cssSelector("*[type='button']"));
        loginButton.click();

        WebElement mailInputField = webDriver.findElement(By.className("Textinput-Control"));
        mailInputField.sendKeys("task30");
        WebElement signInButton = webDriver.findElement(By.id("passp:sign-in"));
        signInButton.click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement enterPasswordField = webDriver.findElement(By.ByClassName.className("Textinput-Control"));
        enterPasswordField.sendKeys("task30task30");
        WebElement submitButton = webDriver.findElement(By.ByXPath.xpath("//*[@id='passp:sign-in']"));
        submitButton.click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assertions.assertTrue(webDriver.findElement(By.ByCssSelector.cssSelector("*[aria-label*='Inbox']")).isDisplayed());
    }

    @AfterEach
    void cleanup(){
        webDriver.close();
    }
}
