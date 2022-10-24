import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailInboxPage {

    private final static By AVATAR = By.cssSelector("a>div.user-pic>img[src]");
    private final static By INBOX = By.cssSelector("div[aria-label*='Inbox']>div>span");
    private final static By USERNAME = By.cssSelector("a[class*=user-account_left] > span.user-account__name");
    private final static By LOGOUT_OPTION = By.xpath("//a[contains(@class, 'action_exit')]");
    private final WebDriver webDriver;

    public MailInboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Click avatar icon")
    private void clickAvatar() {
        webDriver.findElement(AVATAR).click();
    }

    @Step("Click logout option in menu")
    private void clickLogout() {
        webDriver.findElement(LOGOUT_OPTION).click();
    }

    @Step("Logout from Yandex mail and getting to Start page")
    public StartPage logout() {
        clickAvatar();
        clickLogout();
        return new StartPage(webDriver);
    }

    @Step("Getting Inbox text")
    public String getInboxText() {
        return webDriver.findElement(INBOX).getText().toLowerCase();
    }

    @Step("Verify username is displayed")
    public boolean isDisplayedUsername() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(INBOX));
        return webDriver.findElement(USERNAME).isDisplayed();
    }
}
