import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.RealItem;
import shop.VirtualItem;

import java.util.Random;

public class RealItemTest {

    private RealItem realItem;

    @BeforeEach
    public void initTestData() {
        realItem = new RealItem();
        realItem.setName(new Faker().aviation().aircraft());
        realItem.setPrice(1000);
        realItem.setWeight(5000);
    }

    @Test
    void testRealItemTest(){
        Assertions.assertTrue(realItem.toString().contains("Weight: 5000"));
    }
}
