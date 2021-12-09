package lesson9;

public class AutomobileRunner {

    public static void main(String[] args) {

        int amount = 10;
        int distance;
        Automobile[] automobiles = new Automobile[amount];

        // Генерация массива автомобилей
        for (int i = 0; i < automobiles.length; i++) {
            if (Math.random() * 10 < 5)
                automobiles[i] = new Car();
            else
                automobiles[i] = new Truck();
        }

        for (int i = 0; i < automobiles.length; i++) {
            distance = (int) (Math.random() * 1000 + 1);
            System.out.print(i + ". Поставлена задача проехать " + distance + " км: ");
            automobiles[i].move(distance);
        }
    }
}
