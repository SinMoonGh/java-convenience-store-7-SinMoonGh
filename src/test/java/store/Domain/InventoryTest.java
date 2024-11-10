package store.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryTest {
    @ParameterizedTest
    @CsvSource({
            "콜라, 3, 7",
            "초코바, 5, 0",
            "에너지바, 1, 4"
    })
    void 일반_상품_수량_변경_테스트(String name, int amount, int result) {
        Inventory inventory = new Inventory();

        inventory.decreaseProductQuantity(name, amount);
        
        assertThat(inventory.getProductQuantity(name)).isEqualTo(result);
    }
}
