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
        return !now.isAfter(promotionEndDate);
    }

    public int disCountPrice() {
        int calculatePresentationProductQuantity = purchaseQuantity / (buy + get);
        return calculatePresentationProductQuantity * price;
    }

    public boolean shouldAddBonusProduct() {
        int remainder = purchaseQuantity % (buy + get);
        return remainder == buy;
    }
}
