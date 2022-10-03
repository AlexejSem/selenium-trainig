import org.openqa.selenium.By;
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
    @FindBy(css = "section>h2")
    WebElement sectionH2;

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeClickable(loginButton));
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(webDriver);
    }
    public String getH2Text() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(sectionH2));
        String text = sectionH2.getText().toLowerCase();
        return text;
    }
}