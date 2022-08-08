import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import shop.VirtualItem;

import java.io.File;
import java.util.Random;

public class VirtualItemTest {

    private VirtualItem virtualItem;

    @BeforeEach
    public void initTestData() {
        virtualItem = new VirtualItem();
        virtualItem.setName(new Faker().aviation().aircraft());
        virtualItem.setPrice(1000);
        virtualItem.setSizeOnDisk(5000);
    }

    @Test
    void testVirtualItemTest(){
        Assertions.assertTrue(virtualItem.toString().contains("Size on disk: 5000"));
    }
}
