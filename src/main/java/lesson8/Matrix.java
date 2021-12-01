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
        //TODO проверка допустимости индексов (if)
        return this.matrix[m][n];
    }

    public void setAmount(int m, int n, int value){
        //TODO проверка допустимости индексов (if)
        this.matrix[m][n] = value;
    }

    // Сложение матриц
    public Matrix add(Matrix matrix) {
        //TODO проверка равных размеров двух матриц (if)
        Matrix matrixResult = new Matrix(matrix.getLengthM(), matrix.getLengthN());
        for (int i = 0; i < matrix.getLengthM(); i++) {
            for (int j = 0; j < matrix.getLengthN(); j++) {
                matrixResult.setAmount(i, j, this.matrix[i][j] + matrix.getAmount(i, j));
            }
        }
        return matrixResult;
    }

    // Вычитание матриц
    public Matrix subtract(Matrix matrix) {
        //TODO проверка равных размеров двух матриц (if)
        Matrix matrixResult = new Matrix(matrix.getLengthM(), matrix.getLengthN());
        for (int i = 0; i < matrix.getLengthM(); i++) {
            for (int j = 0; j < matrix.getLengthN(); j++) {
                matrixResult.setAmount(i, j, this.matrix[i][j] - matrix.getAmount(i, j));
            }
        }
        return matrixResult;
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
        //TODO проверка arg >= 1 (if)
        Matrix identityMatrix = new Matrix(arg, arg);
        for (int i = 0; i < arg; i++) {
            identityMatrix.setAmount(i, i, 1);
        }
        return identityMatrix;
    }

    // Умножение матриц
    public Matrix multiply(Matrix matrix) {
        //TODO проверка соответствия размеров двух матриц для операции умножения (if (this.getLengthM == getLengthN))
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

    // Возведение матрицы в квадрат
    public Matrix square() {
        //TODO проверка "квадратности" матрицы (if (this.getLengthM == this.getLengthN))
        Matrix matrixResult = new Matrix(this.getLengthM(), this.getLengthN());
        matrixResult = this.multiply(this);
        return matrixResult;
    }

    // Возведение матрицы в куб
    public Matrix cube() {
        //TODO проверка "квадратности" матрицы (if (this.getLengthM == this.getLengthN))
        Matrix matrixResult = new Matrix(this.getLengthM(), this.getLengthN());
        matrixResult = this.multiply(this);
        matrixResult = matrixResult.multiply(this);
        return matrixResult;
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
