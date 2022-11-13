package page;

import helper.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ShopPage extends BasePage {

    private WebDriver driver;
    private final static By LIST_VIEW = By.cssSelector("li#list");
    private final static By PRODUCT_CONTAINER = By.cssSelector(".product_container");
    private final static By ADD_TO_CART =
            By.xpath("//div[@id='center_column']/ul/li//a[@title='Add to cart']");
    private final static By PRODUCT_PRICE =
            By.xpath("//li//div[contains(@class, 'col')]/span[@itemprop='price']");
    private final static By CART = By.cssSelector("div.shopping_cart > a[href]");
    private final static By CONTINUE_SHOPPING = By.cssSelector("div.button-container > span[title='Continue shopping']");

    public ShopPage() {
    }

    private void clickProductsListView() {
        driver.findElement(LIST_VIEW).click();
    }


    public double addProductsToCart(int qty) {
        clickProductsListView();
        double totalPrice = 0.00;
        List<WebElement> containers = driver.findElements(PRODUCT_CONTAINER);
        for (int k = 0; k < qty; k++) {
            int i = new Random().nextInt(containers.size());
            totalPrice += TestUtil.priceParser(containers.get(i).findElement(PRODUCT_PRICE).getText());
            containers.get(i).findElement(ADD_TO_CART).click();
            driver.findElement(CONTINUE_SHOPPING).click();
        }
        return totalPrice;
    }

    public CartPage navigateToCartPage() {
        driver.findElement(CART).click();
        return new CartPage();
    }

}
