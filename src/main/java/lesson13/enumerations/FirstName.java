package lesson13.enumerations;

public enum FirstName {

    Александр (1), Алексей (2), Андрей (3), Борис (4), Владимир(5), Василий(6),
            Виталий(7), Евгений(8), Михаил(9), Роман(10);

    private int index;

    FirstName(int index) {
        this.index = index;
    }

    public static FirstName as(int index) {
        for (FirstName firstName : values()) {
            if (firstName.index == index) {
                return firstName;
            }
        }
        return FirstName.Александр;
    }
}
