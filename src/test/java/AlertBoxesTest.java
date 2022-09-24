import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AlertBoxesTest {

    WebDriver webDriver;

    @BeforeEach
    void setup(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        webDriver.manage().window().fullscreen();
    }

    @Test
    void alertBoxTest(){
        WebElement alertBoxButton = webDriver.findElement(By.cssSelector("button.btn[onclick='myAlertFunction()']"));
        alertBoxButton.click();
        try {
            Alert alert = webDriver.switchTo().alert();
            String textOnAlert = alert.getText();
            alert.accept();
            assertEquals("I am an alert box!",textOnAlert);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void confirmBoxAcceptTest(){
        String parentWindowId = webDriver.getWindowHandle();
        WebElement confirmBoxButton = webDriver.findElement(By.cssSelector("button.btn[onclick='myConfirmFunction()']"));
        confirmBoxButton.click();
        try{
            Alert confirm = webDriver.switchTo().alert();
            confirm.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().window(parentWindowId);
        WebElement message = webDriver.findElement(By.cssSelector("p#confirm-demo"));
        System.out.println(message.getText());
        assertEquals("You pressed OK!", message.getText());
    }

    @Test
    void confirmBoxDismissTest(){
        String parentWindowId = webDriver.getWindowHandle();
        WebElement confirmBoxButton = webDriver.findElement(By.cssSelector("button.btn[onclick='myConfirmFunction()']"));
        confirmBoxButton.click();
        try{
            Alert confirm = webDriver.switchTo().alert();
            confirm.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().window(parentWindowId);
        WebElement message = webDriver.findElement(By.cssSelector("p#confirm-demo"));
        assertEquals("You pressed Cancel!", message.getText());
    }

    @AfterEach
    void cleanup(){
        webDriver.close();
    }
}
