package lesson11;

public class Car {

    private String type;
    private String number;
    private int speed; // km/h
    private int weight; // kg
    private int width; // cm
    private int height; // cm
    private int length; // cm

    public Car(String type, String number, int speed, int weight, int width, int height, int length) {
        this.type = type;
        this.number = number;
        this.speed = speed;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public String asString() {

        return this.type + ", " + this.number + ", " + speed + " km/h, " + weight + " kg";
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
