import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import java.util.Random;

public class VirtualItemTest implements TestLifecycleLogger {

    @Test
    void VirtualItemFieldsTest(){
        VirtualItem virtualItem = new VirtualItem();
        String name = new Faker().lebowski().character();
        double price = new Random().nextDouble(500,5000);
        double sizeOnDisk = new Random().nextDouble(256,4096);
        virtualItem.setName(name);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(sizeOnDisk);

        Assertions.assertNotNull(virtualItem);
        Assertions.assertEquals(name,virtualItem.getName());
        Assertions.assertEquals(price,virtualItem.getPrice());
        Assertions.assertEquals(sizeOnDisk,virtualItem.getSizeOnDisk());
    }
}
