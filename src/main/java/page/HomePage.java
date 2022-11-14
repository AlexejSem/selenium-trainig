package page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final static By SIGN_IN_BUTTON = By.cssSelector("a.login");

    public HomePage() {
        super();
    }

    public AuthenticationPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AuthenticationPage();
    }

}
