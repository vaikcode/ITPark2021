package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinAvgRunner {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int length;

        System.out.print("Введите длину массива: ");
        if (!console.hasNextInt()) {
            System.out.println("ОШИБКА! Должно быть введено число.");
            return;
        } else {
            length = console.nextInt();
            if (length < 1) {
                System.out.println("ОШИБКА! Должно быть введено число больше нуля.");
                return;
            }
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Максимальное значение в массиве: " + maxOfArray(array));
        System.out.println("Минимальное значение в массиве : " + minOfArray(array));
        System.out.println("Среднее значение массива       : " + avgOfArray(array));
    }

    public static int maxOfArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

    public static int minOfArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
        }
        return min;
    }

    public static double avgOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (double) sum / array.length;
    }
}
