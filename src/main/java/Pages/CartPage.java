package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private final static By CART_TABLE = By.cssSelector("table#cart_summary>tbody");
    private final static By CART_TABLE_ROW = By.cssSelector("table#cart_summary>tbody>tr");
    private final static By TOTAL_PRODUCT_PRICE = By.cssSelector("td#total_product");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getExpectedProductTotal() {
        return Double.parseDouble(driver.findElement(TOTAL_PRODUCT_PRICE).getText().replace("$",""));
    }

    public int countDifferentProductsInCart() {
        List<WebElement> rows = driver.findElement(CART_TABLE).findElements(CART_TABLE_ROW);
        return rows.size();
    }
}
