package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyWishlistsPage {

    private WebDriver driver;
    private final static By CREATED_WISHLIST = By.cssSelector("tbody > tr:first-child > td:nth-child(1) > a");

    private final static By QUANTITY_OF_PRODUCTS = By.xpath("//tbody/tr[1]/td[2]");
    private final static By NEW_WISHLISTS_INPUT = By.cssSelector("input#name");
    private final static By SAVE_WISHLIST_BUTTON = By.cssSelector("button#submitWishlist");
    private final static By FIRST_TOP_PRODUCT = By.xpath("//div[@id='best-sellers_block_right']//li[1]");
    private final static By DELETE_WISHLIST = By.xpath("//tr[1]/ td[@class='wishlist_delete']/a");

    public MyWishlistsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWishListCreated() {
        return driver.findElement(CREATED_WISHLIST).isDisplayed();
    }

    public int productsDisplayedInWishList() {
        return Integer.parseInt(driver.findElement(QUANTITY_OF_PRODUCTS).getText());
    }

    public void createNewWishList(String wishListName) {
        driver.findElement(NEW_WISHLISTS_INPUT).sendKeys(wishListName);
        driver.findElement(SAVE_WISHLIST_BUTTON).click();
    }

    public TopProductPage getToFirstTopProduct() {
        driver.findElement(FIRST_TOP_PRODUCT).click();
        return new TopProductPage(driver);
    }

    public void deleteWishList() {
        driver.findElement(DELETE_WISHLIST).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
}
