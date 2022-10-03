import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {

    private WebDriver webDriver;

    private static By LOGIN_BUTTON = By.cssSelector("button[type]");
    private static final By SECTION_H2 = By.cssSelector("section>h2");

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
    }
    public LoginPage clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(webDriver);
    }
    public String getH2Text() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.presenceOfElementLocated(SECTION_H2));
        String text = webDriver.findElement(SECTION_H2).getText().toLowerCase();
        return text;
    }
}