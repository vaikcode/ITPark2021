package lesson10.enumerations;

public enum Temperature {

    CELSIUS(1), FAHRENHEIT(2), KELVIN(3);

    private int index;

    Temperature(int index) {
        this.index = index;
    }

    public static Temperature as(int index) {
        for (Temperature temperature : values()) {
            if (temperature.index == index) {
                return temperature;
            }
        }
        return Temperature.CELSIUS;
    }
}
