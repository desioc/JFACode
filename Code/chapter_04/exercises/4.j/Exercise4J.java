public class Exercise4J {
    public static void main(String args[]) {
       int i = 1, j = 1;
       do {
           if (i % 3 == 0){
               System.out.println("Number multiple of 3 = " + i);
               j++;
           }
           i++;
        } while(j <= 10) ;
    }
}