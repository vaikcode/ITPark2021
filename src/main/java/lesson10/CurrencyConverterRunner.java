package lesson10;

import lesson10.enumerations.Currency;
import lesson10.interfaces.Convertable;

public class CurrencyConverterRunner {

    public static void main(String[] args) {

        Convertable convertable = new CurrencyConverter();

        convertable.convertCurrency(Currency.RUR, Currency.USD, 10);
        convertable.convertCurrency(Currency.RUR, Currency.EUR, 10);
        convertable.convertCurrency(Currency.USD, Currency.RUR, 738.5);
        convertable.convertCurrency(Currency.USD, Currency.EUR, 100);
        convertable.convertCurrency(Currency.EUR, Currency.RUR, 833.6);
        convertable.convertCurrency(Currency.EUR, Currency.USD, 88.37);
    }
}
