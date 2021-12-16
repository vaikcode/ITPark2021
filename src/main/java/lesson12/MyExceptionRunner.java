package lesson12;

import lesson12.exception.MyArrayDataException;
import lesson12.exception.MyArraySizeException;

import java.util.Arrays;

public class MyExceptionRunner {

    public static void main(String[] args) {

        String[][] strings1 = new String[4][4];
        String[][] strings2 = new String[4][4];
        String[][] strings3 = new String[4][4];
        String[][] strings4 = new String[5][5];

        RandomFillInteger(strings1);
        RandomFillInteger(strings2);
        RandomFillInteger(strings3);
        RandomFillInteger(strings4);

        RandomSetError(strings2);
        RandomSetError(strings3);

        System.out.println("Содержимое массива string1[][]: " + Arrays.deepToString(strings1));
        System.out.println("Содержимое массива string2[][]: " + Arrays.deepToString(strings2));
        System.out.println("Содержимое массива string3[][]: " + Arrays.deepToString(strings3));
        System.out.println("Содержимое массива string4[][]: " + Arrays.deepToString(strings4));
        System.out.println();

        System.out.println("1) Обработка массива strings1[][]");
        try {
            System.out.println("Сумма элементов массива string1[][]: " + ArrayTester(strings1));
        } catch (MyArraySizeException sizeException) {
            System.out.println(sizeException.getMessage() + " Размер текущего массива " + sizeException.getLengthM()
                    + "x" + sizeException.getLengthN() + ".");
        } catch (MyArrayDataException dataException) {
            System.out.println(dataException.getMessage() + " Значение в ячейке [" + dataException.getM()
                    + "][" + dataException.getN() + "] : " + dataException.getString());
        }

        System.out.println("2) Обработка массива strings2[][]");
        try {
            System.out.println("Сумма элементов массива string2[][]: " + ArrayTester(strings2));
        } catch (MyArraySizeException sizeException) {
            System.out.println(sizeException.getMessage() + " Размер текущего массива " + sizeException.getLengthM()
                    + "x" + sizeException.getLengthN() + ".");
        } catch (MyArrayDataException dataException) {
            System.out.println(dataException.getMessage() + " Значение в ячейке [" + dataException.getM()
                    + "][" + dataException.getN() + "] : " + dataException.getString());
        }

        System.out.println("3) Обработка массива strings3[][]");
        try {
            System.out.println("Сумма элементов массива string3[][]: " + ArrayTester(strings3));
        } catch (MyArraySizeException sizeException) {
            System.out.println(sizeException.getMessage() + " Размер текущего массива " + sizeException.getLengthM()
                    + "x" + sizeException.getLengthN() + ".");
        } catch (MyArrayDataException dataException) {
            System.out.println(dataException.getMessage() + " Значение в ячейке [" + dataException.getM()
                    + "][" + dataException.getN() + "] : " + dataException.getString());
        }

        System.out.println("4) Обработка массива strings4[][]");
        try {
            System.out.println("Сумма элементов массива string4[][]: " + ArrayTester(strings4));
        } catch (MyArraySizeException sizeException) {
            System.out.println(sizeException.getMessage() + " Размер текущего массива " + sizeException.getLengthM()
                    + "x" + sizeException.getLengthN() + ".");
        } catch (MyArrayDataException dataException) {
            System.out.println(dataException.getMessage() + " Значение в ячейке [" + dataException.getM()
                    + "][" + dataException.getN() + "] : " + dataException.getString());
        }
    }

    public static void RandomFillInteger(String[][] strings){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] = Integer.toString((int) (Math.random() * 100));
            }
        }
    }

    public static void RandomSetError(String[][] strings){
        int i = (int) (Math.random() * (strings.length));
        int j = (int) (Math.random() * (strings[i].length));
        strings[i][j] = "SOME_ERROR_STRING";
    }

    public static int ArrayTester(String[][] strings){
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException(strings, "ОШИБКА. Размер массива не равен 4х4.");
        }
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(strings, i, j, "ОШИБКА. Значение в ячейке массива не число.");
                }
            }
        }
        return sum;
    }
}
