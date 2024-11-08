package store.Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import store.Utils.SearchProductName;

public class PromotionDiscount {

    private final String name;
    private final int quantity;
    private final String now;
    private final SearchProductName searchProductName;

    public PromotionDiscount(String name, int quantity, String now, SearchProductName searchProductName) {
        this.name = name;
        this.quantity = quantity;
        this.now = now;
        this.searchProductName = searchProductName;
    }

    public Promotions findPromotion(String promotion) {
        for (Promotions promotionValue : Promotions.values()) {
            if (promotionValue.name().equals(promotion)) {
                return promotionValue;
            }
        }
        throw new IllegalArgumentException("해당 프로모션을 찾을 수 없습니다: " + promotion);
    }

    public LocalDate convertStringToLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate parsedDate = LocalDate.parse(now.substring(0, 10));

        return parsedDate;
    }

    public boolean checkTheEvent() {
        String promotion = searchProductName.findPromotionsProductName().getPromotion();
        LocalDate promotionEndDate = findPromotion(promotion).getEndDate();
        LocalDate now = convertStringToLocalDate();
        boolean eventGoingOn = !now.isAfter(promotionEndDate);

        return eventGoingOn;
    }
}
