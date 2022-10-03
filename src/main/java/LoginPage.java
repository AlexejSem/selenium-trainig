import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    private final static By EMAIL_FIELD = By.id("passp-field-login");
    private final static By SIGNIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void inputEmail(String login) {
        webDriver.findElement(EMAIL_FIELD).sendKeys(login);
    }
    private void inputPassword(String password) {
        webDriver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    private void clickSinginButton() {
        webDriver.findElement(SIGNIN_BUTTON).click();
    }
    public MailInboxPage loginToMail(String login, String password) {
        inputEmail(login);
        clickSinginButton();
        inputPassword(password);
        clickSinginButton();
        return new MailInboxPage(webDriver);
    }
}
