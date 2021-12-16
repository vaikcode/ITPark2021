package lesson8;

public class Wolf extends Canidae {

    public Wolf(String name) {
        super.type = "Волк";
        super.name = name;
    }

    @Override
    public String voice(){
        return "Уууу-уууу";
    }
}
