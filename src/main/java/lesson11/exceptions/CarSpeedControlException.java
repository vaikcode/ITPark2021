package lesson11.exceptions;

import lesson11.Car;

public class CarSpeedControlException extends RuntimeException{
    public CarSpeedControlException(Car car) {
        if (car.getSpeed() > 80 && car.getSpeed() <= 100) {
            System.out.println("Внимание! Проезд через КПП невозможен по скорости: " + car.getType() + " с номером "
                    + car.getNumber() + " движется со скоростью " + car.getSpeed() + " км/ч.");
        } else if (car.getSpeed() > 100) {
            System.out.println("Внимание! Проезд через КПП невозможен по скорости: " + car.getType() + " с номером "
                    + car.getNumber() + " движется со скоростью " + car.getSpeed()
                    + " км/ч. Автомобиль задержан полицией!");
        }
    }
}
