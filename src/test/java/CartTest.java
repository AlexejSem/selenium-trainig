import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parser.JsonParser;
import shop.Cart;
import shop.VirtualItem;
import java.io.File;


public class CartTest {

    private Cart testCart;
    private VirtualItem virtualItem;

    @BeforeClass
    public void initTestData() {
        JsonParser parser = new JsonParser();
        testCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        virtualItem = new VirtualItem();
        virtualItem.setName(new Faker().aviation().aircraft());
        virtualItem.setPrice(1000);
        virtualItem.setSizeOnDisk(5000);
        testCart.addVirtualItem(virtualItem);
    }

    @Test
    void testTotalCalculationWhileAddingItem() {
        final double totalPrice = testCart.getTotalPrice();
        Assert.assertEquals(totalPrice, 27760.68);
    }

    @Test
    void testTotalCalculationWhileDeletingItem() {
        testCart.deleteVirtualItem(virtualItem);
        final double totalPrice = testCart.getTotalPrice();
        Assert.assertNotEquals(totalPrice, 26560.68);
    }

    @AfterClass
    void cleanup(){
        testCart = null;
        virtualItem = null;
    }
}
