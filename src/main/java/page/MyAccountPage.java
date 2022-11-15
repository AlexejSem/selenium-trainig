package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helper.Constants.CATEGORY_PANEL;

public class MyAccountPage extends BasePage {

    private final static By MY_ACCOUNT_TITLE = By.cssSelector("h1.page-heading");
    private final static By MY_WISHLISTS_BUTTON = By.cssSelector("li.lnk_wishlist");

    public MyAccountPage() {
        super();
    }

    public boolean myAccountPageIsDisplayed() {
        return driver.findElement(MY_ACCOUNT_TITLE).isDisplayed();
    }

    public MyWishlistsPage getToMyWishlistsPage() {
        driver.findElement(MY_WISHLISTS_BUTTON).click();
        return new MyWishlistsPage();
    }

    public ShopPage selectCategory(String categoryName) {
        List<WebElement> categories = driver.findElements(CATEGORY_PANEL);
        for (WebElement category : categories) {
            if (category.getText().equals(categoryName)) {
                category.click();
            }
        }
        return new ShopPage();
    }

}
