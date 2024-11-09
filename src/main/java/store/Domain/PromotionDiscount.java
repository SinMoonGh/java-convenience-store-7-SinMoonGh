package store.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import store.Utils.Inquiry;

public class PromotionDiscount {

    //    private final int quantity;
    private final LocalDate now;
    private final Inquiry inquiry;
    private final LocalDate promotionEndDate;

    public PromotionDiscount(LocalDateTime now, Inquiry inquiry) {
        this.now = now.toLocalDate();
        this.inquiry = inquiry;
        this.promotionEndDate = inquiry.findPromotion().getEndDate();
    }

    public PromotionDiscount(LocalDate now, LocalDate promotionEndDate) {
        this.now = now;
        this.inquiry = null;
        this.promotionEndDate = promotionEndDate;
    }

    public boolean checkTheEvent() {

        return !now.isAfter(promotionEndDate);
    }
}
