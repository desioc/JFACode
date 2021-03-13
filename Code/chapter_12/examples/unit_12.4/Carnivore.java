public class Carnivore<H extends Herbivore> implements Animal<H> {
    public void eat(H herbivore) {
        //a carnivore could eat herbivores
    }
}