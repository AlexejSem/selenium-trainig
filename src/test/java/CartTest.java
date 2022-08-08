import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;


public class CartTest implements TestLifecycleLogger {

    @Test
    void RealItemPriceComparing(){
        RealItem realItem = new RealItem();
        realItem.setName(new Faker().aviation().aircraft());
        realItem.setPrice(new Faker().number().randomDouble(2,1000,10000));
        realItem.setWeight(new Faker().number().randomDouble(2,1,5000));
        Cart cart = new Cart(new Faker().funnyName().name());
        cart.addRealItem(realItem);
        double realItemPricePLusTaxes = realItem.getPrice() + realItem.getPrice() * 0.2;

        Assertions.assertNotNull(cart);
        Assertions.assertEquals(realItemPricePLusTaxes,  cart.getTotalPrice());
        cart.deleteRealItem(realItem);
    }

    @Test
    void VirtuallItemPriceComparing(){
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName(new Faker().aviation().aircraft());
        virtualItem.setPrice(new Faker().number().randomDouble(2,1000,10000));
        virtualItem.setSizeOnDisk(new Faker().number().randomDouble(2,256,5000));
        Cart cart = new Cart(new Faker().funnyName().name());
        cart.addVirtualItem(virtualItem);
        double virtuallItemPricePLusTaxes = virtualItem.getPrice() + virtualItem.getPrice() * 0.2;

        Assertions.assertNotNull(cart);
        Assertions.assertEquals(virtuallItemPricePLusTaxes,  cart.getTotalPrice());
        cart.deleteVirtualItem(virtualItem);
    }

}
