package lesson7;

public class Dog {

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " метров");
        } else {
            System.out.println("Собака не может пробежать больше 500 метров");
        }
    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " метров");
        } else {
            System.out.println("Собака не может проплыть больше 10 метров");
        }
    }
}
