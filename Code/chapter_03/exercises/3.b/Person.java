/**
 * Abstract the concept of Person
 */
public class Person {
   /**
    * Represents the person name.
    */
    public String name;
    /**
     * Represents the person surname.
     */
    public String surname;
    /**
     * Represents the number of years of the current person.
     */
    public int age;
     /**
      * Retrieves the person details.
      *
      * @return a string that concatenates the name, the surname e the number of years of the current person.
      */
    public String details() {
        return name + " " + surname + " years " + age;
    }
}