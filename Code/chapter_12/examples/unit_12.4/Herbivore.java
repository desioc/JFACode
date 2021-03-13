public class Herbivore<G extends Grass> implements Food, Animal<G> {
    public void eat(G grass) {
        //a herbivore could eat grass
    }

    public String getColor() {
        //. . .
        return "Brown"; //default color, but could be useful to implement a setColor() method
    }
}