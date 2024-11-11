package store.Domain;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import store.Utils.Inquiry;

public class PromotionDiscount {

    private final int purchaseQuantity;
    private final LocalDate now;
    private final LocalDate promotionEndDate;
    private final int buy;
    private final int get;
    private final int price;

    public PromotionDiscount(int purchaseQuantity, Inquiry inquiry) {
        this.purchaseQuantity = purchaseQuantity;
        this.now = DateTimes.now().toLocalDate();
        this.promotionEndDate = inquiry.findPromotion().getEndDate();
        this.buy = inquiry.findPromotion().getBuy();
        this.get = inquiry.findPromotion().getGet();
        this.price = inquiry.findPromotionsProductName().getPrice();
    }

    public PromotionDiscount(LocalDate now, LocalDate promotionEndDate) {
        this.purchaseQuantity = 0;
        this.now = now;
        this.buy = 0;
        this.get = 0;
        this.price = 0;
        this.promotionEndDate = promotionEndDate;
    }

    public boolean checkTheEvent() {
        // 이벤트 시작 일자가 없음... 이벤트 전체 기간을 구해야 함.
        return !now.isAfter(promotionEndDate);
    }

    public int disCountPrice() {
        int calculatePresentationProductQuantity = purchaseQuantity / (buy + get);
        return calculatePresentationProductQuantity * price * get; // get을 곱할 필요가 있나?
    }

    public int calculateRemainingQuantityAfterPromotion(int totalInventory) {
        return totalInventory % (buy + get);
    }

    public int getFilteredProducts(int totalInventory) {
        int calculate = totalInventory / (buy + get);
        return calculate * (buy + get);
    }

    public boolean shouldAddBonusProduct() {
        int remainder = purchaseQuantity % (buy + get);
        return remainder == buy;
    }
}
