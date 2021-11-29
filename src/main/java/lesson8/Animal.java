package lesson8;

public class Animal {

    protected String type;
    protected String name;

    public void Animal(String name){
        this.type = "Undefined animal";
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public String voice(){
        return "Undefined voice";
    }
}
