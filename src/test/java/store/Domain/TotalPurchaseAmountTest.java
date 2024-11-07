package store.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TotalPurchaseAmountTest {
    @Test
    void 총_구매액_정상_동작_테스트() {
        String name = "콜라";
        int quantity = 8;
        TotalPurchaseAmount totalPurchaseAmount = new TotalPurchaseAmount(name, quantity);

        assertThat(totalPurchaseAmount.calculate()).isEqualTo(8000);
    }

    @Test
    void 상품_이름으로_가격_조회_동작_테스트() {
        String name = "비타민워터";
        int quantity = 8;
        TotalPurchaseAmount totalPurchaseAmount = new TotalPurchaseAmount(name, quantity);

        assertThat(totalPurchaseAmount.findProductName(name).getPrice()).isEqualTo(1500);
    }

    @ParameterizedTest
    @CsvSource({
            "물, false",
            "컵라면, true",
            "오렌지주스, true"
    })
    void 상품이_프로모션_혜택을_받는지_확인(String input, boolean expectedResult) {
        int quantity = 1;
        TotalPurchaseAmount totalPurchaseAmount = new TotalPurchaseAmount(input, quantity);
        Products name = totalPurchaseAmount.findProductName(input);

        assertThat(totalPurchaseAmount.checkProductsThatBenefit(name)).isEqualTo(expectedResult);
    }
}
