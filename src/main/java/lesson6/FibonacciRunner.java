package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciRunner {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int elementNumber;
        int[] fibonacciArray = new int[100];

        for (int i = 0; i < fibonacciArray.length; i++) {
            fibonacciArray[i] = -1;
        }

        while (true) {
            System.out.println("Массив: " + Arrays.toString(fibonacciArray));
            System.out.print("Введите номер числа Фибоначчи (от 0 до 99): ");
            elementNumber = console.nextInt();
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

    private static int fibonacciNumber(int elementNumber) {
        int fibonacciNumberNMinus1 = 0;
        int fibonacciNumberN = 1;
        int fibonacciNumber = 0;

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
