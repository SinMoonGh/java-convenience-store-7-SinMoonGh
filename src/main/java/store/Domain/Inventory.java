package store.Domain;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> products;
    private final Map<String, Integer> promotions;

    public Inventory() {
        this.products = new HashMap<>();
        this.promotions = new HashMap<>();

        saveProductQuantity();           // products 맵 초기화
        savePromotionProductQuantity();
    }

    private void saveProductQuantity() {
        for (Products product : Products.values()) {
            products.put(product.getName(), product.getQuantity());
        }
    }

    private void savePromotionProductQuantity() {
        for (ProductsPromotions product : ProductsPromotions.values()) {
            promotions.put(product.getName(), product.getQuantity());
        }
    }

    public int getProductQuantity(String productName) {
        return products.getOrDefault(productName, 0);
    }

    public int getPromotionProductQuantity(String productName) {
        return promotions.getOrDefault(productName, 0);
    }

    public void decreaseProductQuantity(String productName, int amount) {
        int currentQuantity = products.getOrDefault(productName, 0);
        if (currentQuantity >= amount) {
            products.put(productName, currentQuantity - amount);
        }

        if (currentQuantity < amount) {
            throw new IllegalArgumentException("상품 재고가 부족합니다.");
        }
    }

    public void decreasePromotionProductQuantity(String productName, int amount) {
        int currentQuantity = promotions.getOrDefault(productName, 0);
        if (currentQuantity >= amount) {
            promotions.put(productName, currentQuantity - amount);
        }

        if (currentQuantity < amount) {
            throw new IllegalArgumentException("프로모션 상품 재고가 부족합니다.");
        }
    }
}
