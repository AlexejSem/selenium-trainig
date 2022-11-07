import Browsers.ChromeBrowser;
import Pages.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistAndCartTest {

    private final static String URL = ("http://automationpractice.com/index.php");
    private static WebDriver driver;
    private static byte[] screenshot;
    private IndexPage indexPage;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;
    private final static String EMAIL = "33@33.rrr";
    private final static String PASSWORD = "1qaz!QAZ";
    private final static String WISHLIST_NAME = "Created by autotest wishlist";
    private final static int EXPECTED_QUANTITY_OF_PRODUCTS = 1;

    @BeforeEach
    void setup() throws MalformedURLException {
        driver = ChromeBrowser.getInstance().getWebDriver();
        driver.get(URL);
        indexPage = new IndexPage(driver);
        authenticationPage = indexPage.clickSignInButton();
        myAccountPage = authenticationPage.login(EMAIL, PASSWORD);
    }

    @Test
    void autoCreationOfWishlistTest() {
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        TopProductPage topProductPage = myWishlistsPage.getToFirstTopProduct();
        topProductPage.addProductToWishList();
        topProductPage.getToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        Assertions.assertTrue(myWishlistsPage.isWishListCreated());
        myWishlistsPage.deleteWishList();
    }

    @Test
    void addingProductToManuallyCreatedWishlist() {
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        myWishlistsPage.createNewWishList(WISHLIST_NAME);
        TopProductPage topProductPage = myWishlistsPage.getToFirstTopProduct();
        topProductPage.addProductToWishList();
        topProductPage.getToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        assertEquals(EXPECTED_QUANTITY_OF_PRODUCTS, myWishlistsPage.productsDisplayedInWishList());
        myWishlistsPage.deleteWishList();
    }

    @Test
    void addProductsToCartTest() {
        WomenCategoryPage womenCategoryPage = myAccountPage.getWomenCategoryPage();
        double expectedPrice = womenCategoryPage.get3ProductsPrice();
        womenCategoryPage.add3ProductsToCart();
        CartPage cartPage = womenCategoryPage.getToCartPage();
        double actualPrice = cartPage.getExpectedProductTotal();
        Assertions.assertAll(() -> assertEquals(expectedPrice, actualPrice),
                () -> assertEquals(3,cartPage.countDifferentProductsInCart()));
    }

    @AfterEach
    void cleanup() {
        screenshot = TestListener.makeScreenshot();
        driver.close();
    }

    public static class TestListener implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            if (context.getExecutionException().isPresent()) {
                Allure.addByteAttachmentAsync(
                        "Page screenshot",
                        "image/png",
                        () -> screenshot
                );
            }
        }

        @Attachment(value = "Page Screenshot", type = "image/png")
        private static byte[] makeScreenshot() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    }


}
