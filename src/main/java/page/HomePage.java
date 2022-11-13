package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;

    private final static By SIGN_IN_BUTTON = By.cssSelector("a.login");

    public HomePage() {
    }

    public AuthenticationPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AuthenticationPage();
    }

}
