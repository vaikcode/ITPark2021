package lesson8;

public class Cat extends Felidae {

    public Cat(String name) {
        super.type = "Кошка";
        super.name = name;
    }

    public String voice(){
        return "Мяу-мяу";
    }
}
