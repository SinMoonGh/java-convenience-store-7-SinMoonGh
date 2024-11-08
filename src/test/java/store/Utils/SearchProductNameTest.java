package store.Utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchProductNameTest {
    @Test
    void 상품_이름으로_가격_조회_동작_테스트() {
        String name = "비타민워터";
        SearchProductName searchProductName = new SearchProductName(name);

        assertThat(searchProductName.findProductName().getPrice()).isEqualTo(1500);
    }

    @ParameterizedTest
    @CsvSource({
            "누가바",
            "바밤바",
            "와우"
    })
    void 상품_조회_시_없는_상품이라면_IllegalArgumentException_예외_발생_테스트(String input) {
        SearchProductName searchProductName = new SearchProductName(input);

        assertThrows(IllegalArgumentException.class, () -> {
            searchProductName.findProductName().getName();
        });
    }

    @ParameterizedTest
    @CsvSource({
            "물, false",
            "콜라, true",
            "오렌지주스, true"
    })
    void 상품이_프로모션_혜택을_받는지_확인(String input, boolean expectedResult) {
        SearchProductName searchProductName = new SearchProductName(input);
        boolean result;

        try {
            searchProductName.findPromotionsProductName().getName();
            result = true;
        } catch (IllegalArgumentException e) {
            result = false;
        }

        assertThat(result).isEqualTo(expectedResult);
    }
}
