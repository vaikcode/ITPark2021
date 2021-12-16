package lesson8;

import java.util.Arrays;

public class Matrix {

    private int lengthM;
    private int lengthN;
    private int[][] matrix;
    private static int[][] identityMatrix;

    public Matrix() {
        matrix = new int[2][2];
    }

    public Matrix(int m, int n) {
        matrix = new int[m][n];
    }

    public void print() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void randomFill(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public int getLengthM(){
        return this.matrix.length;
    }

    public int getLengthN(){
        return this.matrix[0].length;
    }

    public int getAmount(int m, int n){
        if (m > this.getLengthM() || n > this.getLengthN() || m < 0 || n < 0) {
            System.out.println("Ошибка в методе Matrix.getAmount(). Индекс за пределами диапазонов матрицы.");
            return 0;
        } else {
            return this.matrix[m][n];
        }
    }

    public void setAmount(int m, int n, int value){
        if (m > this.getLengthM() || n > this.getLengthN() || m < 0 || n < 0) {
            System.out.println("Ошибка в методе Matrix.setAmount(). Индекс за пределами диапазонов матрицы.");
        } else {
            this.matrix[m][n] = value;
        }
    }

    // Сложение матриц
    public Matrix add(Matrix matrix) {
        if (matrix.getLengthM() != this.getLengthM() || matrix.getLengthN() > this.getLengthN()) {
            System.out.println("Ошибка в методе Matrix.add(). Слагаемые матрицы разного размера.");
            return null;
        } else {
            Matrix matrixResult = new Matrix(matrix.getLengthM(), matrix.getLengthN());
            for (int i = 0; i < matrix.getLengthM(); i++) {
                for (int j = 0; j < matrix.getLengthN(); j++) {
                    matrixResult.setAmount(i, j, this.matrix[i][j] + matrix.getAmount(i, j));
                }
            }
            return matrixResult;
        }
    }

    // Вычитание матриц
    public Matrix subtract(Matrix matrix) {
        if (matrix.getLengthM() != this.getLengthM() || matrix.getLengthN() > this.getLengthN()) {
            System.out.println("Ошибка в методе Matrix.subtract(). Вычитаемые матрицы разного размера.");
            return null;
        } else {
            Matrix matrixResult = new Matrix(matrix.getLengthM(), matrix.getLengthN());
            for (int i = 0; i < matrix.getLengthM(); i++) {
                for (int j = 0; j < matrix.getLengthN(); j++) {
                    matrixResult.setAmount(i, j, this.matrix[i][j] - matrix.getAmount(i, j));
                }
            }
            return matrixResult;
        }
    }

    // Умножение матрицы на число
    public void scalarMultiply(int arg) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                this.matrix[i][j] *= arg;
            }
        }
    }

    // Возврат единичной матрицы
    public static Matrix identityMatrix(int arg) {
        if (arg < 1) {
            System.out.println("Ошибка в методе Matrix.identityMatrix(). Индекс должен быть больше нуля.");
            return null;
        } else {
            Matrix identityMatrix = new Matrix(arg, arg);
            for (int i = 0; i < arg; i++) {
                identityMatrix.setAmount(i, i, 1);
            }
            return identityMatrix;
        }
    }

    // Умножение матриц
    public Matrix multiply(Matrix matrix) {
        if (this.getLengthM() != matrix.getLengthN()) {
            System.out.println("Ошибка в методе Matrix.multiply(). Размеры матриц не соответсвуют операции умножения.");
            return null;
        } else {
            Matrix matrixResult = new Matrix(this.getLengthM(), matrix.getLengthN());
            for (int i = 0; i < this.getLengthM(); i++) {
                for (int j = 0; j < matrix.getLengthN(); j++) {
                    for (int k = 0; k < matrix.getLengthM(); k++) {
                        matrixResult.setAmount(i, j, matrixResult.getAmount(i, j) + this.matrix[i][k]
                                * matrix.getAmount(k, j));
                    }
                }
            }
            return matrixResult;
        }
    }

    // Возведение матрицы в квадрат
    public Matrix square() {
        if (this.getLengthM() != this.getLengthN()) {
            System.out.println("Ошибка в методе Matrix.square(). Матрица должна быть квадратной.");
            return null;
        } else {
            Matrix matrixResult = new Matrix(this.getLengthM(), this.getLengthN());
            matrixResult = this.multiply(this);
            return matrixResult;
        }
    }

    // Возведение матрицы в куб
    public Matrix cube() {
        if (this.getLengthM() != this.getLengthN()) {
            System.out.println("Ошибка в методе Matrix.cube(). Матрица должна быть квадратной.");
            return null;
        } else {
            Matrix matrixResult = new Matrix(this.getLengthM(), this.getLengthN());
            matrixResult = this.multiply(this);
            matrixResult = matrixResult.multiply(this);
            return matrixResult;
        }
    }

    //TODO метод инвертирования матрицы в реализации без параметров
    public void invert() {

    }

    //TODO метод инвертирования матрицы - статическая реализация, принимающая на вход параметр-матрицы
    public static void invert(Matrix matrix) {

    }

    //TODO метод вычисления определителя
    public int determinant() {
        return -1;
    }

    //TODO метод расчета обратной матрицы *
    public Matrix inverse() {
        return null;
    }

    //TODO метод вычисления ранга матрицы **
    public int rank() {
        return -1;
    }
}
