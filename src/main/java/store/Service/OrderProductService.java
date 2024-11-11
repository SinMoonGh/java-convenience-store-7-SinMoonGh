package store.Service;

import java.util.Map;
import store.Domain.Inventory;
import store.Domain.PromotionDiscount;
import store.Handler.OrderHandler;

public class OrderProductService implements OrderHandler {

    private String productName;
    private int quantity;
    private Map<String, Integer> products;

    @Override
    public void processOrder(String productName, int quantity, Inventory inventory,
                             PromotionDiscount promotionDiscount) {

        this.productName = productName;
        this.quantity = quantity;
        this.products = inventory.getProducts();
    }

    public int getProductQuantity() {
        return products.getOrDefault(productName, 0);
    }

    public void decreaseProductQuantity(int quantity) {
        int currentQuantity = products.getOrDefault(productName, 0);
        if (currentQuantity >= quantity) {
            products.put(productName, currentQuantity - quantity);
        }

        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("상품 재고가 부족합니다.");
        }
    }
}
