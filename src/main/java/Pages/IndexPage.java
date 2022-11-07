package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    private final static By SIGN_IN_BUTTON = By.cssSelector("a.login");
    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AuthenticationPage(driver);
    }

}
