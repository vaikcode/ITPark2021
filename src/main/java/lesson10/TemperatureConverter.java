package lesson10;

import lesson10.enumerations.Currency;
import lesson10.enumerations.Temperature;
import lesson10.interfaces.Convertable;

public class TemperatureConverter implements Convertable {

    @Override
    public void convertCurrency(Currency currencyIn, Currency currencyOut, double amount) {

    }

    @Override
    public void convertTemperature(Temperature temperatureIn, Temperature temperatureOut, double amount) {
        if (temperatureIn == Temperature.CELSIUS && temperatureOut == Temperature.FAHRENHEIT) {
            System.out.println(amount + " градусов Цельсия = " + (amount * 9 / 5 + 32) + " градусов Фаренгейта");
        }
        if (temperatureIn == Temperature.CELSIUS && temperatureOut == Temperature.KELVIN) {
            System.out.println(amount + " градусов Цельсия = " + (amount + 273.15) + " градусов Кельвина");
        }
        if (temperatureIn == Temperature.FAHRENHEIT && temperatureOut == Temperature.CELSIUS) {
            System.out.println(amount + " градусов Фаренгейта = " + (amount - 32) * 5 / 9 + " градусов Цельсия");
        }
        if (temperatureIn == Temperature.FAHRENHEIT && temperatureOut == Temperature.KELVIN) {
            System.out.println(amount + " градусов Фаренгейта = " + (amount + 459.67) * 5 / 9 + " градусов Кельвина");
        }
        if (temperatureIn == Temperature.KELVIN && temperatureOut == Temperature.CELSIUS) {
            System.out.println(amount + " градусов Кельвина = " + (amount - 273.15) + " градусов Цельсия");
        }
        if (temperatureIn == Temperature.KELVIN && temperatureOut == Temperature.FAHRENHEIT) {
            System.out.println(amount + " градусов Кельвина = " + (amount * 9 / 5 - 459.67) + " градусов Фаренгейта");
        }
    }
}
