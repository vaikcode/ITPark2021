package lesson11.exceptions;

import lesson11.Car;

public class CarParametersException extends RuntimeException {


    public CarParametersException(Car car) {
        if (car.getWeight() > 8000) {
            System.out.println("Внимание! Проезд через КПП невозможен по массе: " + car.getType() + " с номером "
                    + car.getNumber() + " имеет массу " + car.getWeight() + " кг.");
        } else if (car.getHeight() > 4000) {
            System.out.println("Внимание! Проезд через КПП невозможен по высоте: " + car.getType() + " с номером "
                    + car.getNumber() + " имеет высоту " + car.getHeight() + " см.");
        } else if (car.getWidth() > 2500) {
            System.out.println("Внимание! Проезд через КПП невозможен по ширине: " + car.getType() + " с номером "
                    + car.getNumber() + " имеет ширину " + car.getWidth() + " см.");
        }
    }
}
