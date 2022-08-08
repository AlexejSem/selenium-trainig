import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;


public class CartTest {

    private Cart testCart;
    private VirtualItem virtualItem;

    @BeforeEach
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
        Assertions.assertEquals(27760.68, totalPrice);
    }

    @Test
    void testTotalCalculationWhileDeletingItem() {
        testCart.deleteVirtualItem(virtualItem);
        final double totalPrice = testCart.getTotalPrice();
        Assertions.assertNotEquals(26560.68, totalPrice);
    }
}
