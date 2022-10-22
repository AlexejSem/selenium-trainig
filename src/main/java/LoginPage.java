import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final static By EMAIL_FIELD = By.id("passp-field-login");
    private final static By SIGNIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Enter with username {0}")
    private void inputEmail(String login) {
        webDriver.findElement(EMAIL_FIELD).sendKeys(login);
    }

    @Step("Enter with password {0}")
    private void inputPassword(String password) {
        webDriver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Click Sign In button")
    private void clickSinginButton() {
        webDriver.findElement(SIGNIN_BUTTON).click();
    }

    @Step("Login with username {0} and password {1}")
    public MailInboxPage loginToMail(String login, String password) {
        inputEmail(login);
        clickSinginButton();
        inputPassword(password);
        clickSinginButton();
        return new MailInboxPage(webDriver);
    }
}