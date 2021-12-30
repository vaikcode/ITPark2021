package lesson13.enumerations;

public enum SecondName {

    Александров (1), Алексеев (2), Андреев (3), Борисов (4), Владимиров(5),
            Васильев(6), Витальев(7), Евгеньев(8), Михайлов(9), Романов(10);

    private int index;

    SecondName(int index) {
        this.index = index;
    }

    public static SecondName as(int index) {
        for (SecondName secondName : values()) {
            if (secondName.index == index) {
                return secondName;
            }
        }
        return SecondName.Александров;
    }
}
