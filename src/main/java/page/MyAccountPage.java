package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helper.Constants.CATEGORY_PANEL;
import static helper.Constants.WOMEN_CATEGORY;

public class MyAccountPage extends BasePage {

    private final static By MY_ACCOUNT_H1 = By.cssSelector("h1.page-heading");
    private final static By MY_WISHLISTS_BUTTON = By.cssSelector("li.lnk_wishlist");

    public MyAccountPage() {
        super();
    }

    public boolean isUserRegistered() {
        return driver.findElement(MY_ACCOUNT_H1).isDisplayed();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(MY_ACCOUNT_H1).isDisplayed();
    }

    public MyWishlistsPage getToMyWishlistsPage() {
        driver.findElement(MY_WISHLISTS_BUTTON).click();
        return new MyWishlistsPage();
    }

    public ShopPage selectWomenCategory() {
        List<WebElement> categories = driver.findElements(CATEGORY_PANEL);
        for (WebElement category : categories) {
            switch (category.getText()) {
                case WOMEN_CATEGORY -> category.click();
            }
        }
        return new ShopPage();
    }

}
