public class BreakDemo {
    public static void main(String args[]) {
        int i = 0;
        while (true) { //infinite loop?
            if (i > 10)
                break; //when we arrive here the loop terminates
            System.out.println(i);
            i++;
        }
    }
}