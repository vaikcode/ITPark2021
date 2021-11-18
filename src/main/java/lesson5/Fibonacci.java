package lesson5;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int elementNumber;

        System.out.println("Расчет i-го элемента последовательности Фибоначчи (i >= 0)");

        while (true) {
            System.out.print("Введите целое положительное число или \"exit\" для выхода: ");
            if (console.hasNextInt()) {
                elementNumber = console.nextInt();
                System.out.println(fibonacciNumber(elementNumber) + "\n");
            } else {
                if (console.hasNextLine() && console.nextLine().equals("exit")) {
                    return;
                }
                System.out.println("Ошибка! Ожидается ввод целого положительного числа.\n");
            }
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
