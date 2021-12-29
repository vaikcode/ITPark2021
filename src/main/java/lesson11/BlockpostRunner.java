package lesson11;

import lesson11.enumerations.CarNumberLetters;
import lesson11.enumerations.CarTypes;
import lesson11.exceptions.CarParametersException;
import lesson11.exceptions.CarSpeedControlException;

public class BlockpostRunner {

//    int amount = 40;
//    Car[] cars = new Car [amount];

    public static void main(String[] args) {

        int amount = 40;
        Car[] cars = new Car [amount];

        for (int i = 0; i < amount; i++) {
            cars[i] = carGenerate();
        }

        for (int i = 0; i < amount; i++) {
            try {
                blockpostRass(cars[i]);
                System.out.println( cars[i].getType() + " с номером " + cars[i].getNumber() + " проехал через КПП.");
            } catch (CarSpeedControlException e) {

            } catch (CarParametersException e) {

            }
        }
    }

    public static void blockpostRass(Car car) {
        if (car.getSpeed() > 80) {
            throw new CarSpeedControlException(car);
        }
        if (car.getWeight() > 8000 || car.getHeight() > 4000 || car.getWidth() > 2500) {
            throw new CarParametersException(car);
        }
    }

    public static Car carGenerate() {

        int intType;
        String type = "";
        String number;
        int speed = 0;  // km/h
        int weight = 0; // kg
        int width = 0;  // cm
        int height = 0; // cm
        int length = 0; // cm

        intType = easyRandom(1, 2);       // 1..2 : 1 - PASSENGERCAR, 2 - TRUCK
        type += CarTypes.as(intType);
        number = carNumberGenerate();
        if (type.equals(CarTypes.PASSENGERCAR.name())) {
            speed = easyRandom(20, 180);       // 20..180 km/h
            weight = easyRandom(2000, 3500);   // 2000..3500 kg
            width = easyRandom(1800, 2200);       // 1800..2200 cm
            height = easyRandom(1200, 2000);      // 1200..2000 cm
            length = easyRandom(4000, 5500);      // 4000..5500 cm
        } else if (type.equals(CarTypes.TRUCK.name())) {
            speed = easyRandom(20, 120);       // 20..120 km/h
            weight = easyRandom(3500, 16000);  // 3500..16000 kg
            width = easyRandom(2000, 2800);     // 2000..2800 cm
            height = easyRandom(2500, 4500);   // 2500..4500 cm
            length = easyRandom(6000, 8000);   // 6000..8000 cm
        }
        return new Car(type, number, speed, weight, width, height, length);
    }

    public static String carNumberGenerate() {

        String carNumber = "";

        carNumber += CarNumberLetters.as(easyRandom(1, 12));      // 1..12 - 1st char
        carNumber += String.format("%03d", easyRandom(1, 999));   // 001..999 - digit number
        carNumber += CarNumberLetters.as(easyRandom(1, 12));      // 1..12 - 2nd char
        carNumber += CarNumberLetters.as(easyRandom(1, 12));      // 1..12 - 3rd char
        carNumber += "-";
        carNumber += String.format("%02d", easyRandom(1, 99));    // 01..99 - RU region

        return carNumber;
    }

    public static int easyRandom(int start, int end){
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
