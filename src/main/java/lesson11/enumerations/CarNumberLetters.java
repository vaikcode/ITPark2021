package lesson11.enumerations;

import lesson10.enumerations.Temperature;

public enum CarNumberLetters {

    A(1), B(2), C(3), E(4), H(5), K(6), M(7), O(8), P(9),
            T(10), X(11), Y(12);

    private int index;

    CarNumberLetters(int index) {
        this.index = index;
    }

    public static CarNumberLetters as(int index) {
        for (CarNumberLetters carNumberLetter : values()) {
            if (carNumberLetter.index == index) {
                return carNumberLetter;
            }
        }
        return CarNumberLetters.A;
    }


}
