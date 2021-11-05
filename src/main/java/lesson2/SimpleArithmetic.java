package lesson2;

public class SimpleArithmetic {

    public static void main(String[] args) {
        int arg1 = 2000000000;
        int arg2 = 103333333;
        int radius = 100;

        System.out.println("Simple arithmetic operations:");
        System.out.println(arg1 + " + " + arg2 + " = " + add(arg1, arg2));
        System.out.println(arg1 + " - " + arg2 + " = " + subtract(arg1, arg2));
        System.out.println(arg1 + " * " + arg2 + " = " + multiply(arg1, arg2));
        System.out.println(arg1 + " / " + arg2 + " = " + divide(arg1, arg2));
        System.out.println();

        double square = ComplicatedArithmetic.circleSquare(radius);
        System.out.println("Square of circle:");
        System.out.println("R = " + radius + ", S = " + square);
        System.out.println();

        double volume = ComplicatedArithmetic.sphereVolume(radius);
        System.out.println("Volume of sphere:");
        System.out.println("R = " + radius + ", S = " + volume);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static long multiply(int a, int b) {
        return (long) a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }
}
