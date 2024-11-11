package store.Handler;

import store.Domain.Inventory;
import store.Domain.PromotionDiscount;

public interface OrderHandler {
    void processOrder(String productName, int quantity, Inventory inventory, PromotionDiscount promotionDiscount);
}
