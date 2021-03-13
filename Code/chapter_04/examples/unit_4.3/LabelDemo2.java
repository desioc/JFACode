public class LabelDemo2 {
    public static void main(String args[]) {
        int j = 1;
        codeBlockLabel: //we can name the label as we want
        {
            while (true) {
                if (j > 10)
                    break codeBlockLabel;
                System.out.println(j);
                j++;
            }
           // System.out.println("This will never be printed!");
        }
    }
}