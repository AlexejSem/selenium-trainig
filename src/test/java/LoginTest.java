import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    private WebDriver webDriver;

    @BeforeEach
    void setWebDriver(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://mail.yandex.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @ParameterizedTest
    @CsvSource({"task30, task30task30",
                "task-40, task40task40"})
    void loginToYandexMailTest(String login, String password) throws InterruptedException {
        WebElement loginButton = webDriver.findElement(By.cssSelector("*[type='button']"));
        loginButton.click();

        WebElement mailInputField = webDriver.findElement(By.className("Textinput-Control"));
        WebElement signInButton = webDriver.findElement(By.id("passp:sign-in"));
        mailInputField.sendKeys(login);
        signInButton.click();



        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='CurrentAccount-avatar']")));

        WebElement enterPasswordField = webDriver.findElement(By.ByClassName.className("Textinput-Control"));
        enterPasswordField.sendKeys(password);
        WebElement submitButton = webDriver.findElement(By.ByXPath.xpath("//*[@id='passp:sign-in']"));
        submitButton.click();

        Thread.sleep(1000);//holds execution of code for 1 second. It's like explicit wait above and helps to upload page.
        webDriver.manage().window().fullscreen();

        new WebDriverWait(webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("a[class*='left']>span.user-account__name"), login));
        Assertions.assertTrue(webDriver.findElement(By.ByCssSelector.cssSelector("*[aria-label*='Inbox']")).isDisplayed());
    }

    @AfterEach
    void cleanup(){
        webDriver.close();
    }
}
