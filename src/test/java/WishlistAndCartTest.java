import helper.TestUtil;
import org.testng.annotations.Listeners;
import page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Constants.*;

@Listeners(TestListener.class)
public class WishlistAndCartTest extends BaseTest {

    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;

    @Test
    void autoCreationOfWishlistTest() {
        myAccountPage = authenticationPage.login(helper.TestUtil.getUser(USA_USER));
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        ProductDetailPage productDetailPage = myWishlistsPage.navigateToProductDetailPage();
        productDetailPage.addProductToWishList();
        productDetailPage.navigateToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        Assert.assertTrue(myWishlistsPage.isWishListCreated());
        myWishlistsPage.deleteWishList();
    }

    @Test
    void addingProductToManuallyCreatedWishlist() {
        myAccountPage = authenticationPage.login(helper.TestUtil.getUser(CANADIAN_USER));
        MyWishlistsPage myWishlistsPage = myAccountPage.getToMyWishlistsPage();
        myWishlistsPage.createNewWishList(WISHLIST_NAME);
        ProductDetailPage productDetailPage = myWishlistsPage.navigateToProductDetailPage();
        productDetailPage.addProductToWishList();
        productDetailPage.navigateToMyAccountPage();
        myAccountPage.getToMyWishlistsPage();
        Assert.assertEquals(EXPECTED_QUANTITY_OF_PRODUCTS, myWishlistsPage.productsDisplayedInWishList());
        myWishlistsPage.deleteWishList();
    }

    @Test
    void addProductsToCartTest() {
        myAccountPage = authenticationPage.login(helper.TestUtil.getUser(EXISTING_USER));
        ShopPage shopPage = myAccountPage.selectWomenCategory();
        double expectedPrice = shopPage.addProductsToCart(TestUtil.randomInt());
        CartPage cartPage = shopPage.navigateToCartPage();
        double actualPrice = cartPage.getActualProductsTotal();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

}
