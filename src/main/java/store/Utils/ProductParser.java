package store.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {
    public Map<String, Integer> parser(String input) {
        Map<String, Integer> productMap = new HashMap<>();

        Pattern pattern = Pattern.compile("\\[(\\w+)-(\\d+)\\]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String productName = matcher.group(1); // 대괄호 안의 이름 부분
            int quantity = Integer.parseInt(matcher.group(2)); // 대괄호 안의 숫자 부분
            productMap.put(productName, quantity);
        }
        return productMap;
    }
}
