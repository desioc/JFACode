public class Exercise2z {
    public static void main(String args[]) {
        City city = new City("Rome");
        Nation nation = new Nation("Italy", city, 60000000);
        System.out.println(nation.name + " has " + city.name + " as its capital");
    }
}