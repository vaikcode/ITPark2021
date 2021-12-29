package lesson11.enumerations;

public enum CarTypes {

    PASSENGERCAR(1), TRUCK(2);

    private int index;

    CarTypes(int index) {
        this.index = index;
    }

    public static CarTypes as(int index) {
        for (CarTypes carType : values()) {
            if (carType.index == index) {
                return carType;
            }
        }
        return CarTypes.PASSENGERCAR;

    }
}
