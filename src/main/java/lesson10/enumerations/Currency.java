package lesson10.enumerations;

public enum Currency {

    RUR(1), USD(2), EUR(3);

    private int index;

    Currency(int index) {
        this.index = index;
    }

    public static Currency as(int index) {
        for (Currency currency : values()) {
            if (currency.index == index) {
                return currency;
            }
        }
        return Currency.RUR;
    }

}
