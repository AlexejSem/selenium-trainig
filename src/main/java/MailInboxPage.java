import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailInboxPage {

    private final WebDriver webDriver;
    private final static By AVATAR = By.cssSelector("div.user-pic>img");
    private final static By INBOX = By.cssSelector("div[aria-label*='Inbox']>div>span");
    private final static By LOGOUT_OPTION = By.xpath("//a[contains(@class, 'action_exit')]");

    public MailInboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void clickAvatar() {
        webDriver.findElement(AVATAR).click();
    }

    private void clickLogout() {
        webDriver.findElement(LOGOUT_OPTION).click();
    }

    public StartPage logout() {
        clickAvatar();
        clickLogout();
        return new StartPage(webDriver);
    }

    public String getInboxText() {
        return webDriver.findElement(INBOX).getText().toLowerCase();
    }
}