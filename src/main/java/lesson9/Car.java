package lesson9;

public final class Car extends Automobile{

    private int maxDistance = 500;

    @Override
    public void move(int distance) {
        if (distance < maxDistance) {
            System.out.printf("Легковой автомобиль проехал %d км. Топлива осталось еще на %d км.%n",
                    distance, maxDistance - distance);
        }
        if (distance == maxDistance) {
            System.out.printf("Легковой автомобиль проехал %d км. Всё топливо израсходовано.`%n", distance);
        }
        if (distance > maxDistance) {
            System.out.printf("Легковой автомобиль проехал %d км. Далее поездка невозможна - закончилось топливо.%n",
                    maxDistance);
        }
    }
}
