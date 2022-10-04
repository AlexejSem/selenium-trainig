import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "passp-field-login")
    WebElement emailInput;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    WebElement signInButton;
    @FindBy(id = "passp-field-passwd")
    WebElement passwordInput;
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private void inputEmail(String login) {
        emailInput.sendKeys(login);
    }

    private void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void clickSingInButton() {
        signInButton.click();
    }

    public MailInboxPage loginToMail(String login, String password) {
        inputEmail(login);
        clickSingInButton();
        inputPassword(password);
        clickSingInButton();
        return new MailInboxPage(webDriver);
    }
}