import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailInboxPage {

    private final WebDriver webDriver;

    public MailInboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = "div.user-pic>img")
    WebElement avatar;
    @FindBy(xpath = "//a[contains(@class, 'action_exit')]")
    WebElement logoutButton;

    private void clickAvatar() {
        avatar.click();
    }
    private void clickLogout() {
        logoutButton.click();
    }
    public StartPage logout() {
        clickAvatar();
        clickLogout();
        return new StartPage(webDriver);
    }
}