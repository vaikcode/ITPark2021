package lesson13.enumerations;

public enum MiddleName {

    Александрович (1), Алексеевич (2), Андрееевич (3), Борисович (4), Владимирович(5),
            Васильевич(6), Витальевич(7), Евгеньевич(8), Михайлович(9), Романович(10);

    private int index;

    MiddleName(int index) {
        this.index = index;
    }

    public static MiddleName as(int index) {
        for (MiddleName middleName : values()) {
            if (middleName.index == index) {
                return middleName;
            }
        }
        return MiddleName.Александрович;
    }
}
