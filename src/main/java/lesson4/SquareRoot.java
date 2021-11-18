package lesson4;

public class SquareRoot {

    public static void main(String[] args) {
        int arg = 1;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        arg = 9;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        arg = 16;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        arg = 25;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        arg = 144;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        arg = 4084441;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtInt(arg));
        System.out.println();
        arg = 2021;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtDouble(arg));
        arg = 4444;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtDouble(arg));
        arg = 54321;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrtDouble(arg));
    }

    public static int sqrtInt (int arg) {
        int squareRoot = 0;
        int nextOddNumber = 1;

        while (arg > 0) {
            arg = arg - nextOddNumber;
            nextOddNumber += 2;
            squareRoot++;
        }
        return squareRoot;
    }

    public static double sqrtDouble (int arg) {
        int digit1 = 0, digit2 = 0, digit3 = 0, digit4 = 0, digit5 = 0;
        double remainder;

        if (arg == 0)
            return 0.0;
        if (arg == 1)
            return 1.0;
        if (arg == 2)
            return 1.4142;

        for (int i = 1; i < arg; i++) {
            if (arg < i * i) {
                digit1 = --i;
                break;
            }
        }

        if (arg == digit1 * digit1)
            return digit1;

        for (int i = 0; i < 11; i++) {
            remainder = (digit1 + i * 0.1) * (digit1 + i * 0.1);
            if (((double) arg) < remainder) {
                digit2 = --i;
                break;
            }
        }

        for (int i = 0; i < 11; i++) {
            remainder = (digit1 + digit2 * 0.1 + i * 0.01) * (digit1 + digit2 * 0.1 + i * 0.01);
            if (((double) arg) < remainder) {
                digit3 = --i;
                break;
            }
        }

        for (int i = 0; i < 11; i++) {
            remainder = (digit1 + digit2 * 0.1 + digit3 * 0.01 + i * 0.001) *
                    (digit1 + digit2 * 0.1 + digit3 * 0.01 + i * 0.001);
            if (((double) arg) < remainder) {
                digit4 = --i;
                break;
            }
        }

        for (int i = 0; i < 11; i++) {
            remainder = (digit1 + digit2 * 0.1 + digit3 * 0.01 + digit4 * 0.001 + i * 0.0001) *
                    (digit1 + digit2 * 0.1 + digit3 * 0.01 + digit4 * 0.001 + i * 0.0001);
            if (((double) arg) < remainder) {
                digit5 = --i;
                break;
            }
        }

        double result = digit1 * 10000 + digit2 * 1000 + digit3 * 100 + digit4 * 10 + digit5;
        return result / 10000;
    }
}
