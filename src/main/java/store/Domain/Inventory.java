package store.Domain;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> products;
    private Map<String, Integer> promotions;

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

    public Map<String, Integer> getPromotions() {
        return promotions;
    }

    public void setPromotions(Map<String, Integer> promotions) {
        this.promotions = promotions;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }
}
