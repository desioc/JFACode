public class Person {
    //...
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(age 
              + " is not a valid age!");
        }
        this.age = age;
        
    }
    public int getAge() {
        return age;
    }
}
