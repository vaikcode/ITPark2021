package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciRunner {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int elementNumber;
        long[] fibonacciArray = new long[99];

        Arrays.fill(fibonacciArray, -1);

        while (true) {
            System.out.println("Массив: " + Arrays.toString(fibonacciArray));
            System.out.print("Введите номер числа Фибоначчи (от 0 до 98) или \"exit\" для выхода: ");
            if (!console.hasNextInt()) {
                if (console.hasNextLine()) {
                    if (console.nextLine().equals("exit")) {
                        break;
                    } else {
                        System.out.println("ОШИБКА! Должно быть введено целое число.");
                        break;
                    }
                }
            }
            elementNumber = console.nextInt();
            if (elementNumber < 0 || elementNumber > 98) {
                System.out.println("ОШИБКА! Должно быть введено число от 0 до 98.");
                break;
            }
            if (fibonacciArray[elementNumber] == -1) {
                fibonacciArray[elementNumber] = fibonacciNumber(elementNumber);
                System.out.println("Число Фибоначчи равно " + fibonacciArray[elementNumber]
                        + ", расчитано как новое");
            } else {
                System.out.println("Число Фибоначчи равно " + fibonacciArray[elementNumber]
                        + ", взято из массива");
            }
            System.out.println();
        }
    }

    private static long fibonacciNumber(int elementNumber) {
        long fibonacciNumberNMinus1 = 0;
        long fibonacciNumberN = 1;
        long fibonacciNumber = 0;

        if (elementNumber == 0)
            return 0;
        if (elementNumber == 1)
            return 1;

        for (int i = 1; i < elementNumber; i++) {
            fibonacciNumber = fibonacciNumberN + fibonacciNumberNMinus1;
            fibonacciNumberNMinus1 = fibonacciNumberN;
            fibonacciNumberN = fibonacciNumber;
        }
        return fibonacciNumber;
    }
}
