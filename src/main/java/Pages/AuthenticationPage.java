package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private final static By EMAIL_CREATE_FIELD = By.cssSelector("#email_create");
    private final static By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@id='SubmitCreate']");
    private final static By EMAIL_FIELD = By.cssSelector("input#email");
    private final static By PASSWORD_FIELD = By.cssSelector("input#passwd");
    private final static By SIGN_IN_BUTTON = By.cssSelector("button#SubmitLogin");
    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage createAccount(String email) {
        driver.findElement(EMAIL_CREATE_FIELD).sendKeys(email);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RegistrationPage(driver);
    }

    public MyAccountPage login(String email, String password) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MyAccountPage(driver);
    }

}