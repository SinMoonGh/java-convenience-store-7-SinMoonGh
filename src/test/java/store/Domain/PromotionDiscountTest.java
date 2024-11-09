package store.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PromotionDiscountTest {
    @ParameterizedTest
    @CsvSource({
            "2024, 1, 30, 2024, 12, 31, true",
            "2024, 5, 30, 2024, 4, 29, false",
            "2024, 5, 30, 2024, 5, 30, true"
    })
    void checkTheEvent_메서드_정상_동작_테스트(int year1, int month1, int dayOfMonth1, int year2, int month2, int dayOfMonth2,
                                     boolean result) {
        LocalDate now = LocalDate.of(year1, month1, dayOfMonth1);
        LocalDate endDate = LocalDate.of(year2, month2, dayOfMonth2);
        PromotionDiscount promotionDiscount = new PromotionDiscount(now, endDate);

        assertThat(promotionDiscount.checkTheEvent()).isEqualTo(result);
    }
}
