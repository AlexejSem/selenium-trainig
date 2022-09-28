import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertBoxesTest {

    private WebDriver webDriver;
    private final static By ALERT_BUTTON = By.cssSelector("button.btn[onclick='myAlertFunction()']");
    private final static By CONFIRM_BUTTON = By.cssSelector("button.btn[onclick='myConfirmFunction()']");
    private final static By CONFIRM_DEMO = By.cssSelector("p#confirm-demo");
    private final static By PROMPT_BOX_BUTTON = By.cssSelector("button.btn[onclick='myPromptFunction()']");
    private final static By PROMPT_DEMO = By.cssSelector("p#prompt-demo");

    @BeforeEach
    void setup() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        webDriver.manage().window().fullscreen();
    }

    @Test
    void alertBoxTest() {
        webDriver.findElement(ALERT_BUTTON).click();
        Alert alert = webDriver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        Assertions.assertEquals("I am an alert box!", textOnAlert);
    }

    @Test
    void confirmBoxAcceptTest() {
        webDriver.findElement(CONFIRM_BUTTON).click();
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        webDriver.switchTo().defaultContent();
        WebElement message = webDriver.findElement(CONFIRM_DEMO);
        Assertions.assertEquals("You pressed OK!", message.getText());
    }

    @Test
    void promptBoxTest() {
        webDriver.findElement(PROMPT_BOX_BUTTON).click();
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Hello Prompt");
        alert.accept();
        webDriver.switchTo().defaultContent();
        WebElement message = webDriver.findElement(PROMPT_DEMO);
        Assertions.assertEquals("You have entered 'Hello Prompt' !", message.getText());
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}
