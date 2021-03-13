public class Exercise13O {
    public static void main(String args[]) {
       String string1 = "123789";
       String string2 = string1.concat(System.lineSeparator());
       char [] array1 = string2.toCharArray();
       char [] array2 = {'4', '5', '6'};
       System.arraycopy(array2, 0, array1, 3, 3);
       System.out.println(array1);
       System.exit(0);
    }
}