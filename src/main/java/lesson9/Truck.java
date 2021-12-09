package lesson9;

public final class Truck extends Automobile{

    private static int maxDistance = 1200;

    @Override
    public void move(int distance) {
        if (distance < maxDistance) {
            System.out.printf("Грузовик проехал %d км. Топлива осталось еще на %d км.%n",
                    distance, maxDistance - distance);
        }
        if (distance == maxDistance) {
            System.out.printf("Грузовик проехал %d км. Всё топливо израсходовано.%n", distance);
        }
        if (distance > maxDistance) {
            System.out.printf("Грузовик проехал %d км. Далее поездка невозможна - закончилось топливо.%n",
                    maxDistance);
        }
    }
}
