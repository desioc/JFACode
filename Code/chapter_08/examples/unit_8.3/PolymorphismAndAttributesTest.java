abstract class Pet {
    public final String name = "Generic Pet";
}

class Dog extends Pet {
    public final String name = "Dog"; 
}

class Cat extends Pet {
    public final String type;
    public Cat(String type){
        this.type = type;
    }
}

public class PolymorphismAndAttributesTest {
    public static void main(String args[]) {
        Pet pet = new Dog();
        System.out.println(pet.name);
        Dog dog = new Dog();
        System.out.println(dog.name);        
    }
}