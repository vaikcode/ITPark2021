package lesson7;

public class PetCat {

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кошка пробежала " + distance + " метров");
        } else {
            System.out.println("Кошка не может пробежать больше 200 метров");
        }
    }

    public void swim(int distance) {
        System.out.println("Извините, но кошка не умеет плавать");
    }
}
