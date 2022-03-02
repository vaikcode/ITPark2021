package lesson22;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPojo {

    // Образец JSON:
    //    {
    //        "success":true,
    //            "timestamp":1646183522,
    //            "base":"EUR",
    //            "date":"2022-03-02",
    //            "rates":{
    //                "RUB":120.725916,
    //                "USD":1.112533,
    //                "GBP":0.834848,
    //                "JPY":127.986882
    //        }
    //    }

    private String success;
    private String timestamp;
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;
//    private BigDecimal rub;
//    private BigDecimal usd;
//    private BigDecimal gbp;
//    private BigDecimal jpy;
}
