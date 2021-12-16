package lesson8;

import java.util.Arrays;

public class MatrixRunner {

    public static void main(String[] args) {

        // Размерность матриц
        int m = 5;
        int n = 3;

        // Матрицы 2х2
        Matrix matrix11 = new Matrix();
        Matrix matrix12 = new Matrix();
        Matrix matrixResult1 = new Matrix();

        // Матрицы 5х3
        Matrix matrix21 = new Matrix(m, n);
        Matrix matrix22 = new Matrix(m, n);
        Matrix matrixResult2 = new Matrix(m, n);

        // Матрицы 3х5
        Matrix matrix31 = new Matrix(n, m);

        matrix11.randomFill();
        matrix12.randomFill();
        matrix21.randomFill();
        matrix22.randomFill();
        matrix31.randomFill();

        System.out.println("=== ОПЕРАЦИИ С МАТРИЦАМИ 2x2 ===");
        System.out.println("Матрица 2х2 #1:");
        matrix11.print();
        System.out.println("Матрица 2х2 #2:");
        matrix12.print();
        System.out.println("Сумма матриц #1 и #2:");
        matrixResult1 = matrix11.add(matrix12);
        matrixResult1.print();
        System.out.println("Разность матриц #1 и #2:");
        matrixResult1 = matrix11.subtract(matrix12);
        matrixResult1.print();
        System.out.println("Умножение матрицы #1 на 10:");
        matrix11.scalarMultiply(10);
        matrix11.print();

        System.out.println("\n=== ОПЕРАЦИИ С МАТРИЦАМИ MxN ===");
        System.out.println("Размерность M = " + matrix21.getLengthM());
        System.out.println("Размерность N = " + matrix21.getLengthN());
        System.out.println("Матрица MxN #1:");
        matrix21.print();
        System.out.println("Матрица MxN #2:");
        matrix22.print();
        System.out.println("Сумма матриц #1 и #2:");
        matrixResult2 = matrix21.add(matrix22);
        matrixResult2.print();
        System.out.println("Разность матриц #1 и #2:");
        matrixResult2 = matrix21.subtract(matrix22);
        matrixResult2.print();
        System.out.println("Умножение матрицы #1 на 10:");
        matrix21.scalarMultiply(10);
        matrix21.print();

        System.out.println("\n=== УСТАНОВКА В ПОЛЕ 5х3 ЗНАЧЕНИЯ 999 ===");
        matrix21.setAmount(4, 2, 999);
        matrix21.print();


        System.out.println("\n=== ВОЗВРАТ ЕДИНИЧНЫХ МАТРИЦ ===");
        Matrix[] matrixArray = new Matrix[5];
        for (int i = 0; i < 5;) {
            matrixArray[i] = Matrix.identityMatrix(++i);
            System.out.println("Единичная матрица размерности " + i + " на " + i + ":");
            matrixArray[i-1].print();
        }

        System.out.println("\n=== УМНОЖЕНИЕ МАТРИЦЫ MxN НА МАТРИЦУ NxM ===");
        System.out.println("Матрица MxN:");
        matrix22.print();
        System.out.println("Матрица NxM:");
        matrix31.print();
        System.out.println("Результат умножения матриц (матрица MxM):");
        Matrix matrixResult3 = new Matrix(m, m);
        matrixResult3 = matrix22.multiply(matrix31);
        matrixResult3.print();

        System.out.println("\n=== ВОЗВЕДЕНИЕ МАТРИЦЫ MxM В КВАДРАТ ===");
        System.out.println("Матрица MxM:");
        Matrix matrix41 = new Matrix(m, m);
        matrix41.randomFill();
        matrix41.print();
        System.out.println("Результат возведения в квадрат:");
        Matrix matrixResult41 = new Matrix(m, m);
        matrixResult41 = matrix41.square();
        matrixResult41.print();

        System.out.println("\n=== ВОЗВЕДЕНИЕ МАТРИЦЫ MxM В КУБ ===");
        System.out.println("Матрица MxN:");
        matrix41.print();
        System.out.println("Результат возведения в куб:");
        Matrix matrixResult42 = new Matrix(m, m);
        matrixResult42 = matrix41.cube();
        matrixResult42.print();
    }
}
