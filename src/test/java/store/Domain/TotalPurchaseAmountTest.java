package store.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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

        assertThat(totalPurchaseAmount.getPriceByName(name)).isEqualTo(1500);
    }
}
