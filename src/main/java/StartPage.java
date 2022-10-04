import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {

    @FindBy(css = "button[type]")
    WebElement loginButton;
    private WebDriver webDriver;

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
        boolean isDisplayed = loginButton.isDisplayed();
        return isDisplayed;
    }
}