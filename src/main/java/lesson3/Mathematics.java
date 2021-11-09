package lesson3;

public class Mathematics {
    public static void main(String[] args) {
        System.out.println("РАСЧЕТ ФАКТОРИАЛОВ:");
        System.out.println("Факториал числа " + 0 + " равен: " + Factorial(0));
        System.out.println("Факториал числа " + 1 + " равен: " + Factorial(1));
        System.out.println("Факториал числа " + 5 + " равен: " + Factorial(5));
        System.out.println("Факториал числа " + 10 + " равен: " + Factorial(10));
        System.out.println("Факториал числа " + 15 + " равен: " + Factorial(15));
        System.out.println();

        System.out.println("РАСЧЕТ КОРНЕЙ КВАДРАТНОГО УРАВНЕНИЯ:");
        int a = 0, b = 17, c = -18;
        QuadraticEquationRoot(a, b, c);
        a = 1;
        QuadraticEquationRoot(a, b, c);
        b = -6;
        c = 9;
        QuadraticEquationRoot(a, b, c);
        a = 2;
        b = -3;
        c = 1;
        QuadraticEquationRoot(a, b, c);
        a = -40;
        c = -50;
        QuadraticEquationRoot(a, b, c);
    }

    private static long Factorial (int n) {
        long factorial = 1;

        for (int i = 1; i < n + 1; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    private static void QuadraticEquationRoot (int a, int b, int c) {

        double root1, root2;

        System.out.print("A=" + a + ", B=" + b + ", C=" + c + ". ");
        if (a == 0) {
            System.out.println("ОШИБКА: Первый коэффициент не может быть 0");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0 ) {
            System.out.println("Нет действительных решений уравнения");
        } else if (discriminant == 0) {
            root1 = -b / (2.0 * a);
            System.out.println("X=" + root1);
        } else {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("X1=" + root1 + ", X2=" + root2);
        }
    }
}
