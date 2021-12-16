package lesson8;

public class Dog extends Canidae {

    public Dog(String name) {
        super.type = "Собака";
        super.name = name;
    }

    @Override
    public String voice(){
        return "Гав-гав";
    }
}
