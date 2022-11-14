package page;

import helper.TestUtil;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final static By TOTAL_PRODUCT_PRICE = By.cssSelector("td#total_product");

    public CartPage() {
        super();
    }

    public double getActualProductsTotal() {
        return TestUtil.priceParser(driver.findElement(TOTAL_PRODUCT_PRICE).getText());
    }

}
