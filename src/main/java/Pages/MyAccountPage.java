package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;
    private final static By MY_ACCOUNT_H1 = By.cssSelector("h1.page-heading");
    private final static By MY_WISHLISTS_BUTTON = By.cssSelector("li.lnk_wishlist");
    private final static By WOMEN_CATEGORY = By.xpath("//li/a[@title='Women']");


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserRegistered() {
        return driver.findElement(MY_ACCOUNT_H1).isDisplayed();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(MY_ACCOUNT_H1).isDisplayed();
    }

    public MyWishlistsPage getToMyWishlistsPage() {
        driver.findElement(MY_WISHLISTS_BUTTON).click();
        return new MyWishlistsPage(driver);
    }

    public WomenCategoryPage getWomenCategoryPage() {
        driver.findElement(WOMEN_CATEGORY).click();
        return new WomenCategoryPage(driver);
    }

}
