package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopProductPage {
    private WebDriver driver;
    private final static By ADD_TO_WISHLIST = By.cssSelector("a#wishlist_button");
    private final static By ACCOUNT_DETAILS = By.cssSelector("a.account");

    public TopProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToWishList() {
        driver.findElement(ADD_TO_WISHLIST).click();
    }

    public MyAccountPage getToMyAccountPage() {
        driver.findElement(ACCOUNT_DETAILS).click();
        return new MyAccountPage(driver);
    }

}
