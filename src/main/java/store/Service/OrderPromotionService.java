package store.Service;

import java.util.Map;
import java.util.Objects;
import store.Domain.Inventory;
import store.Domain.PromotionDiscount;
import store.Handler.OrderHandler;
import store.View.InputView;

public class OrderPromotionService implements OrderHandler {
    private String productName;
    private int quantity;
    private Map<String, Integer> promotions;
    private PromotionDiscount promotionDiscount;

    @Override
    public void processOrder(String productName, int quantity, Inventory inventory,
                             PromotionDiscount promotionDiscount) {

        this.productName = productName;
        this.quantity = quantity;
        this.promotions = inventory.getPromotions();
        this.promotionDiscount = promotionDiscount;
    }

    public int getPromotionProductQuantity() {
        return promotions.getOrDefault(productName, 0);
    }

    public void decreasePromotionProductQuantity(InputView inputView, OrderProductService orderProductService) {
        int currentQuantity = promotions.getOrDefault(productName, 0);
        if (currentQuantity >= quantity) {
            promotions.put(productName, currentQuantity - quantity);
        }

        if (currentQuantity < quantity) {
            String applyFullPriceForPartialQuantity = inputView.readItem();
            applyFullPriceOrCancelIneligibleProducts(applyFullPriceForPartialQuantity, orderProductService,
                    currentQuantity);
        }
    }

    private void applyFullPriceOrCancelIneligibleProducts(String eligibility, OrderProductService orderProductService,
                                                          int currentQuantity) {
        if (Objects.equals(eligibility, "Y")) {
            deductFromRegularStockIfPromotionStockInsufficient(orderProductService, currentQuantity);
        }

        if (Objects.equals(eligibility, "N")) {
            payForPromotionProducts(currentQuantity);
        }
    }

    private void deductFromRegularStockIfPromotionStockInsufficient(
            OrderProductService orderProductService, int currentQuantity) {

        int totalInventory = getPromotionProductQuantity();
        int remainder = promotionDiscount.calculateRemainingQuantityAfterPromotion(totalInventory);

        promotions.put(productName, currentQuantity - promotionDiscount.getFilteredProducts(totalInventory));
        orderProductService.decreaseProductQuantity(remainder);
    }

    private void payForPromotionProducts(int currentQuantity) {
        int totalInventory = getPromotionProductQuantity();

        promotions.put(productName, currentQuantity - promotionDiscount.getFilteredProducts(totalInventory));
    }
}
