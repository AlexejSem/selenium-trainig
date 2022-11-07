package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenCategoryPage {

    private WebDriver driver;
    private final static By LIST_VIEW = By.cssSelector("li#list");
    private final static By ADD_1ST_PRODUCT_TO_CART =
            By.xpath("//div[@id='center_column']/ul/li[1]//a[@title='Add to cart']");
    private final static By ADD_2ND_PRODUCT_TO_CART =
            By.xpath("//div[@id='center_column']/ul/li[2]//a[@title='Add to cart']");
    private final static By ADD_3RD_PRODUCT_TO_CART =
            By.xpath("//div[@id='center_column']/ul/li[3]//a[@title='Add to cart']");
    private final static By PRICE_OF_1ST_PRODUCT =
            By.xpath("//li[1]//div[contains(@class, 'col')]/span[@itemprop='price']");
    private final static By PRICE_OF_2ND_PRODUCT =
            By.xpath("//li[2]//div[contains(@class, 'col')]/span[@itemprop='price']");
    private final static By PRICE_OF_3RD_PRODUCT =
            By.xpath("//li[3]//div[contains(@class, 'col')]/span[@itemprop='price']");
    private final static By CART = By.cssSelector("div.shopping_cart > a[href]");
    private final static By CONTINUE_SHOPPING = By.cssSelector("div.button-container > span[title='Continue shopping']");
    private double productPrice;

    public WomenCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickProductsListView() {
        driver.findElement(LIST_VIEW).click();
    }

    public double get3ProductsPrice(){
        clickProductsListView();
        productPrice = Double.parseDouble((driver.findElement(PRICE_OF_1ST_PRODUCT).getText()).replace("$",""));
        productPrice = productPrice + Double.parseDouble(driver.findElement(PRICE_OF_2ND_PRODUCT).getText().replace("$",""));
        productPrice = productPrice + Double.parseDouble(driver.findElement(PRICE_OF_3RD_PRODUCT).getText().replace("$",""));
        return productPrice;
    }

    public void add3ProductsToCart() {
        driver.findElement(ADD_1ST_PRODUCT_TO_CART).click();
        driver.findElement(CONTINUE_SHOPPING).click();
        driver.findElement(ADD_2ND_PRODUCT_TO_CART).click();
        driver.findElement(CONTINUE_SHOPPING).click();
        driver.findElement(ADD_3RD_PRODUCT_TO_CART).click();
        driver.findElement(CONTINUE_SHOPPING).click();
    }
    public CartPage getToCartPage() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

}
