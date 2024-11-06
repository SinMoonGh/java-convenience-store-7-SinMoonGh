package store.View;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"[감자-3]", "[감자-3],[버섯-4]", "[감자-3],[버섯-4],[송이버섯-5]"})
    void 상품_입력_정상_실행(String input) {
        InputView inputView = new InputView();
        String[] splitInput = input.split(",");

        Arrays.stream(splitInput).forEach(inputView::validateInput);
    }

    @Test
    void 대괄호_이외_특수_문자_사용_금지() {
        InputView inputView = new InputView();
        String input = "/감자-3/";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInput(input);
        });
    }

    @Test
    void 대괄호_중복_사용_금지() {
        InputView inputView = new InputView();
        String input = "[감자-3][소고기-4]";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInput(input);
        });
    }

    @Test
    void 여는_대괄호와_닫는_대괄호로_상품_구분() {
        InputView inputView = new InputView();
        String input = "[감자-3";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInput(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"[ 감자-3 ]", "[감자 - 3]"})
    void 스페이스_허용_안됨(String input) {
        InputView inputView = new InputView();

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInput(input);
        });
    }

    @Test
    void 상품_이름과_상품_수량이_반대로_입력되면_예외_발생() {
        InputView inputView = new InputView();
        String input = "[3-감자]";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInput(input);
        });
    }

    @Test
    void 상품_목록에_없는_상품_입력_시_예외_발생() {

    }

    @ParameterizedTest
    @DisplayName("null 값 또는 empty 값으로 예외 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void createUserExceptionFromNullOrEmpty(String text) {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.validateInput(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
