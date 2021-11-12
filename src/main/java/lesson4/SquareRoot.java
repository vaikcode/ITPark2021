package lesson4;

public class SquareRoot {

    public static void main(String[] args) {
        int arg = 1;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
        arg = 9;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
        arg = 16;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
        arg = 25;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
        arg = 144;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
        arg = 4084441;
        System.out.println("Квадратный корень из числа " + arg + " равен " + sqrt(arg));
    }

    public static int sqrt (int arg) {
        int squareRoot = 0;
        int nextOddNumber = 1;

        while (arg > 0) {
            arg = arg - nextOddNumber;
            nextOddNumber += 2;
            squareRoot++;
        }
        return squareRoot;
    }
}
