package store.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readItem() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        String input = Console.readLine();
        return input;
        // ...
    }

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null이거나 빈칸입니다.");
        }

        if (!input.matches("[a-zA-Z0-9가-힣\\[\\]\\-]*")) {
            throw new IllegalArgumentException("[ERROR] 중괄호 이외의 특수 기호가 포함되어 있거나 스페이스를 사용하셨습니다.");
        }

        if (!input.matches("\\[[a-zA-Z0-9가-힣\\-]*\\]$")) {
            throw new IllegalArgumentException("[ERROR] 여러 상품을 담으실 때 상품 사이에 쉼표로 구분해 주세요.");
        }

        if (input.matches(".*\\[\\d.*")) {
            throw new IllegalArgumentException("[ERROR] 대괄호 뒤에 숫자가 올 수 없습니다.");
        }
    }
}
