package store.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"[감자-3],[버섯-4],[송이버섯-5]"})
    void 정상_동작_테스트(String input) {
        ProductParser productParser = new ProductParser();

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("감자", 3);
        expectedMap.put("버섯", 4);
        expectedMap.put("송이버섯", 5);

        Map<String, Integer> actualMap = productParser.parser(input);

        assertEquals(expectedMap, actualMap);
    }

    
}
