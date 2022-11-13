package page;

import helper.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {

    private final static By EMAIL_CREATE_FIELD = By.cssSelector("#email_create");
    private final static By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@id='SubmitCreate']");
    private final static By EMAIL_FIELD = By.cssSelector("input#email");
    private final static By PASSWORD_FIELD = By.cssSelector("input#passwd");
    private final static By SIGN_IN_BUTTON = By.cssSelector("button#SubmitLogin");
    private WebDriver driver;

    public AuthenticationPage() {
    }

    public RegistrationPage createAccount(String email) {
        driver.findElement(EMAIL_CREATE_FIELD).sendKeys(email);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RegistrationPage();
    }

    public MyAccountPage login(User user) {
        driver.findElement(EMAIL_FIELD).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_FIELD).sendKeys(user.getPassword());
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MyAccountPage();
    }

}