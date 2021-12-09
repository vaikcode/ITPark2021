package lesson10.interfaces;

import lesson10.enumerations.Currency;
import lesson10.enumerations.Temperature;

public interface Convertable {

    void convertTemperature(Temperature temperatureIn, Temperature temperatureOut, double amount);
    void convertCurrency(Currency currencyIn, Currency currencyOut, double amount);
}
