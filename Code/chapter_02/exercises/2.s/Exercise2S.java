public class Exercise2S {
    
    public static void main(String args[]){
        Course course1 = new Course();
        course1.name = "Java";
        Course course2 = new Course("Java");
        System.out.println(course1.name);
        System.out.println(course2.name);
    }
  
}