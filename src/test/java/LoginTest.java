import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    private WebDriver webDriver;
    private final static By LOGIN_BUTTON = By.cssSelector("button[type]");
    private final static By EMAIL_FIELD = By.id("passp-field-login");
    private final static By SIGNIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final static By USERNAME = By.cssSelector("a[class*='left']>span.user-account__name");

    @BeforeEach
    void setWebDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
        webDriver.navigate().to("https://mail.yandex.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @ParameterizedTest
    @CsvSource({"task30, task30task30",
                "task-40, task40task40"})
    void loginToYandexMailTest(String login, String password) throws InterruptedException {
        webDriver.findElement(LOGIN_BUTTON).click();
        webDriver.findElement(EMAIL_FIELD).sendKeys(login);
        webDriver.findElement(SIGNIN_BUTTON).click();
        webDriver.findElement(PASSWORD_FIELD).sendKeys(password);
        webDriver.findElement(SIGNIN_BUTTON).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(7))
                .until(ExpectedConditions.invisibilityOfElementWithText(USERNAME, login));
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}
