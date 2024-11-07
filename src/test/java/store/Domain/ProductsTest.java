package store.Domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    void 프로모션_상품_호출() {
        List<String> result = Arrays.asList("콜라", "사이다", "물", "비타민워터", "감자칩", "초코바", "에너지바", "정식도시락", "컵라면");

        List<String> promotionProducts = Arrays.stream(Products.values())
                .filter(product -> product.getPromotion() == null)
                .map(Products::getName)
                .collect(Collectors.toList());

        assertEquals(promotionProducts, result);
    }
}
