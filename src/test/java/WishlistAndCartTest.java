import helper.TestUtil;
import helper.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Constants.*;

@Listeners(TestListener.class)
public class WishlistAndCartTest extends BaseTest {

    private MyAccountPage myAccountPage;
    private MyWishlistsPage myWishlistsPage;

    @Test
    void autoCreationOfWishlistTest() {
        User user = TestUtil.getUser(USA_USER);
        myAccountPage = authenticationPage.login(user);
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        ProductDetailPage productDetailPage = myWishlistsPage.navigateToProductDetailPage();
        productDetailPage.addProductToWishList();
        productDetailPage.navigateToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        Assert.assertTrue(myWishlistsPage.isWishListCreated());
    }

    @Test
    void addingProductToManuallyCreatedWishlist() {
        User user = TestUtil.getUser(CANADIAN_USER);
        myAccountPage = authenticationPage.login(user);
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        myWishlistsPage.createNewWishList(WISHLIST_NAME);
        ProductDetailPage productDetailPage = myWishlistsPage.navigateToProductDetailPage();
        productDetailPage.addProductToWishList();
        productDetailPage.navigateToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        Assert.assertEquals(EXPECTED_QUANTITY_OF_PRODUCTS, myWishlistsPage.getWishListProductsQty());
    }

    @Test
    void addProductsToCartTest() {
        User user = TestUtil.getUser(EXISTING_USER);
        myAccountPage = authenticationPage.login(user);
        ShopPage shopPage = myAccountPage.selectCategory(WOMEN_CATEGORY);
        double expectedPrice = shopPage.addProductsToCart(TestUtil.randomInt());
        CartPage cartPage = shopPage.navigateToCartPage();
        double actualPrice = cartPage.getActualProductsTotal();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @AfterMethod
    public void clearWishList() {
        if (myWishlistsPage.isWishListCreated()) {
            myWishlistsPage.deleteWishList();
        }
    }

}
