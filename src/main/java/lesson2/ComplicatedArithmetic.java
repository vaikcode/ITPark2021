package lesson2;

public class ComplicatedArithmetic {

    public static final double PI = 3.14159265;

    public static double circleSquare(int radius){
        return PI * (double) radius * radius;
    }

    public static double sphereVolume(int radius){
        return PI * (double) radius * radius * radius * 4 / 3;
    }
}