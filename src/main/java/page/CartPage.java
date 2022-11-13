package page;

import helper.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private WebDriver driver;
    private final static By TOTAL_PRODUCT_PRICE = By.cssSelector("td#total_product");

    public CartPage() {
    }

    public double getActualProductsTotal() {
        return TestUtil.priceParser(driver.findElement(TOTAL_PRODUCT_PRICE).getText());
    }

}
