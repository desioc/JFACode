public class AnimalsTest {
    public static void main(String[] args) {
        Animal<Herbivore> tiger = new Carnivore<Herbivore>();
        Herbivore<Grass> herbivore = new Herbivore<Grass>();
        Grass grass = new Grass();
        herbivore.eat(grass);
        tiger.eat(herbivore);
    }
}