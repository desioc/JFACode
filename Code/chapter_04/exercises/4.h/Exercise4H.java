public class Exercise4H {
    public static void main(String args[]) {
       for (int i = 1, j = 1; j <= 10; i++) {
           if (i % 3 == 0){
               System.out.println("Number multiple of 3 = " + i);
               j++;
           }
        }
    }
}