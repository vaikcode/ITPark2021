package lesson8;

public class AnimalRunner {

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Tiger tiger = new Tiger("Макс");
        Dog dog = new Dog("Чапа");
        Wolf wolf = new Wolf("Грэй");

        System.out.println("ЖИВОТНЫЕ ГОВОРЯТ РАЗДЕЛЬНО:");
        System.out.println(cat.getType() + " " + cat.getName() + " говорит: "+ cat.voice());
        System.out.println(tiger.getType() + " " + tiger.getName() + " говорит: "+ tiger.voice());
        System.out.println(dog.getType() + " " + dog.getName() + " говорит: "+ dog.voice());
        System.out.println(wolf.getType() + " " + wolf.getName() + " говорит: "+ wolf.voice());

        Animal[] animals = new Animal[4];
        animals[0] = cat;
        animals[1] = tiger;
        animals[2] = dog;
        animals[3] = wolf;

        System.out.println();
        System.out.println("ЖИВОТНЫЕ ГОВОРЯТ В МАССИВЕ:");
        for (Animal animal : animals){
            System.out.println(animal.getType() + " " + animal.getName() + " говорит: " + animal.voice());
        }
    }
}
