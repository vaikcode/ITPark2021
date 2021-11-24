package lesson7;

public class Tiger {

    public void run(int distance) {
        if (distance <= 400) {
            System.out.println("Тигр пробежал " + distance + " метров");
        } else {
            System.out.println("Тигр не может пробежать больше 400 метров");
        }
    }

    public void swim(int distance) {
        System.out.println("Извините, но тигр не умеет плавать");
    }
}
