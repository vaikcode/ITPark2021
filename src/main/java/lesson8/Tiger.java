package lesson8;

public class Tiger extends Felidae {

    public Tiger(String name) {
        super.type = "Тигр";
        super.name = name;
    }

    @Override
    public String voice(){
        return "Рррр-рррр";
    }

}
