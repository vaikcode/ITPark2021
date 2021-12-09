package lesson10;

import lesson10.enumerations.Currency;
import lesson10.enumerations.Temperature;
import lesson10.interfaces.Convertable;

public class CurrencyConverter implements Convertable {

    private double currentRurUsd = 73.85;
    private double currentRurEur = 83.36;
    private double currentUsdEur = 0.8837;

    @Override
    public void convertTemperature(Temperature temperatureIn, Temperature temperatureOut, double amount) {

    }

    @Override
    public void convertCurrency(Currency currencyIn, Currency currencyOut, double amount) {
        if (currencyIn == Currency.RUR && currencyOut == Currency.USD) {
            System.out.println(amount + " рублей = " + amount * currentRurUsd + " долларов США");
        }
        if (currencyIn == Currency.RUR && currencyOut == Currency.EUR) {
            System.out.println(amount + " рублей = " + amount * currentRurEur + " евро");
        }
        if (currencyIn == Currency.USD && currencyOut == Currency.RUR) {
            System.out.println(amount + " долларов США = " + amount / currentRurUsd + " рублей");
        }
        if (currencyIn == Currency.USD && currencyOut == Currency.EUR) {
            System.out.println(amount + " долларов США = " + amount * currentUsdEur + " евро");
        }
        if (currencyIn == Currency.EUR && currencyOut == Currency.RUR) {
            System.out.println(amount + " евро = " + amount / currentRurEur + " рублей");
        }
        if (currencyIn == Currency.EUR && currencyOut == Currency.USD) {
            System.out.println(amount + " евро = " + amount / currentUsdEur + " долларов США");
        }
    }
}
