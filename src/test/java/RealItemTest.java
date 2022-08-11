import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTest {

    private RealItem realItem;

    @BeforeClass
    public void initTestData() {
        realItem = new RealItem();
        realItem.setName(new Faker().aviation().aircraft());
        realItem.setPrice(1000);
        realItem.setWeight(5000);
    }

    @Test
    void testRealItemTest(){
        Assert.assertTrue(realItem.toString().contains("Weight: 5000"));
    }

    @AfterClass
    void cleanup(){
        realItem = null;
    }
}
