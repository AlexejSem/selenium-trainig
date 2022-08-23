import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTest {

    private VirtualItem virtualItem;

    @BeforeClass
    public void initTestData() {
        virtualItem = new VirtualItem();
        virtualItem.setName(new Faker().aviation().aircraft());
        virtualItem.setPrice(1000);
        virtualItem.setSizeOnDisk(5000);
    }

    @Test
    void testVirtualItemTest(){
        Assert.assertTrue(virtualItem.toString().contains("Size on disk: 5000"));
    }

    @AfterClass
    public void cleanup() {
        virtualItem = null;
    }
}
