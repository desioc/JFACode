public class LabelDemo {
    public static void main(String args[]) {
        int j = 1;
        foo: //we can name the label as we want
        while (true) {
            while (true) {
                if (j > 10)
                break foo;
                System.out.println(j);
                j++;
            }
        }
    }
}