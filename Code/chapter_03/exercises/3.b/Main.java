public class Main {
    public static void main (String args []) {
        Person person1 = new Person();
        Person person2 = new Person();
        person1.name = "Alessandro";
        person1.surname = "Scarlatti";
        person1.age = 30;
        System.out.println("person1 "+person1.details());
        person2.name = "Antonio";
        person2.surname = "Vivaldi";
        person2.age = 40;
        System.out.println("person2 "+person2.details());
        Person person3 = person1;
        System.out.println("person3 "+person3.details());
    }
}