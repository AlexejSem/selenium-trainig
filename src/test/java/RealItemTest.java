import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import java.util.Random;

public class RealItemTest implements TestLifecycleLogger {

    @Test
    void RealItemFieldsTest(){
        RealItem realItem = new RealItem();
        String name = new Faker().hitchhikersGuideToTheGalaxy().character();
        double price = new Random().nextDouble(1000,10000);
        double weight = new Random().nextDouble(0.5,9.99);
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);

        Assertions.assertNotNull(realItem);
        Assertions.assertEquals(name,realItem.getName());
        Assertions.assertEquals(price,realItem.getPrice());
        Assertions.assertEquals(weight,realItem.getWeight());
    }


}
