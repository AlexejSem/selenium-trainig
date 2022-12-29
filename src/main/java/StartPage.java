import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {

    private WebDriver webDriver;

    @FindBy(css = "button[type]")
    WebElement loginButton;

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(webDriver);
    }

    public boolean isLoginButtonDisplayed() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }
}