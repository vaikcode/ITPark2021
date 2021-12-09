package lesson10;

import lesson10.enumerations.Temperature;
import lesson10.interfaces.Convertable;

public class TemperatureConverterRunner {

    public static void main(String[] args) {

        Convertable convertable = new TemperatureConverter();

        convertable.convertTemperature(Temperature.CELSIUS, Temperature.FAHRENHEIT, 36.6);
        convertable.convertTemperature(Temperature.CELSIUS, Temperature.KELVIN, 36.6);
        convertable.convertTemperature(Temperature.FAHRENHEIT, Temperature.CELSIUS, 97.88);
        convertable.convertTemperature(Temperature.FAHRENHEIT, Temperature.KELVIN, 97.88);
        convertable.convertTemperature(Temperature.KELVIN, Temperature.CELSIUS, 309.75);
        convertable.convertTemperature(Temperature.KELVIN, Temperature.FAHRENHEIT, 309.75);
    }
}
