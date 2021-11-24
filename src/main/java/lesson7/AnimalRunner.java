package lesson7;

public class AnimalRunner {

    public static void main(String[] args) {
        Dog dog = new Dog();
        PetCat petCat = new PetCat();
        Tiger tiger = new Tiger();

        dog.run(500);
        dog.run(600);
        dog.swim(10);
        dog.swim(15);
        System.out.println();

        petCat.run(200);
        petCat.run(300);
        petCat.swim(10);
        System.out.println();

        tiger.run(400);
        tiger.run(500);
        tiger.swim(10);
    }
}
