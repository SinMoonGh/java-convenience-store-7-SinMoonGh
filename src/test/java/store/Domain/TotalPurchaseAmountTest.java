package store.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import store.Utils.SearchProductName;

public class TotalPurchaseAmountTest {
    @Test
    void 총_구매액_정상_동작_테스트() {
        String name = "콜라";
        int quantity = 8;
        SearchProductName searchProductName = new SearchProductName(name);
        TotalPurchaseAmount totalPurchaseAmount = new TotalPurchaseAmount(quantity, searchProductName);

        assertThat(totalPurchaseAmount.calculate()).isEqualTo(8000);
    }
}
