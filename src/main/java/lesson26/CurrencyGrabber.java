package lesson26;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyGrabber extends RuntimeException {

    private Map<String, BigDecimal> currencies = Collections.emptyMap();

    public BigDecimal getCurrency(String code) {
        return currencies.get(code);
    }

    @PostConstruct
    void postInit() {
        try {
            final DocumentContext context = JsonPath.parse(new URL("https://www.cbr-xml-daily.ru/daily_json.js"));
            final List<Map<String, Object>> valutes = context.read("$.Valute.*", List.class);
            currencies = valutes.stream()
                    .map(it -> Pair.of(it.get("CharCode").toString(), new BigDecimal(it.get("Value").toString())))
                    .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}