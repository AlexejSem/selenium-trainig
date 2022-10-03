import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailInboxPage {

    private final WebDriver webDriver;

    public MailInboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final static By AVATAR = By.cssSelector("div.user-pic>img");
    private final static By LOGOUT_OPTION = By.xpath("//a[contains(@class, 'action_exit')]");

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
}