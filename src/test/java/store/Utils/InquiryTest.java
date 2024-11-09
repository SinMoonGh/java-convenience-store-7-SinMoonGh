package store.Utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InquiryTest {
    @Test
    void 상품_이름으로_가격_조회_동작_테스트() {
        String name = "비타민워터";
        Inquiry inquiry = new Inquiry(name);

        assertThat(inquiry.findProductName().getPrice()).isEqualTo(1500);
    }

    @ParameterizedTest
    @CsvSource({
            "누가바",
            "바밤바",
            "와우"
    })
    void 상품_조회_시_없는_상품이라면_IllegalArgumentException_예외_발생_테스트(String input) {
        Inquiry inquiry = new Inquiry(input);

        assertThrows(IllegalArgumentException.class, () -> {
            inquiry.findProductName().getName();
        });
    }

    @ParameterizedTest
    @CsvSource({
            "물, false",
            "콜라, true",
            "오렌지주스, true"
    })
    void 상품이_프로모션_혜택을_받는지_확인(String input, boolean expectedResult) {
        boolean result;
        Inquiry inquiry = new Inquiry(input);

        try {
            inquiry.findPromotionsProductName().getName();
            result = true;
        } catch (IllegalArgumentException e) {
            result = false;
        }

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "콜라, 2024-12-31",
            "오렌지주스, 2024-12-31",
            "감자칩, 2024-11-30"
    })
    void findPromotion_메서드_정상_작동_테스트(String products, String promotions) {
        Inquiry inquiry = new Inquiry(products);
        
        LocalDate endDate = inquiry.findPromotion().getEndDate();

        assertThat(endDate).isEqualTo(promotions);
    }
}
