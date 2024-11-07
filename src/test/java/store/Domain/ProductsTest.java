package store.Domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductsTest {
    @Test
    void 상품_호출_성공() {
        String name = Products.VITAMIN_WATER.getName();
        int price = Products.VITAMIN_WATER.getPrice();
        int quantity = Products.VITAMIN_WATER.getQuantity();
        String promotion = Products.VITAMIN_WATER.getPromotion();

        assertEquals(name, "비타민워터");
        assertEquals(price, 1500);
        assertEquals(quantity, 6);
        assertEquals(promotion, null);
    }
}
