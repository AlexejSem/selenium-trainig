import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {

    private WebDriver webDriver;
    private static By LOGIN_BUTTON = By.cssSelector("button[type]");

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(webDriver);
    }

    public boolean isLogInButtonDisplayed() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        return webDriver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}