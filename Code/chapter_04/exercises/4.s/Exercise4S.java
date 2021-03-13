public class Exercise4S {

    private static int matrix[][] = {
        {1, 7, 3, 9, 5, 3},
        {6, 2, 3},
        {7, 5, 1, 4, 0},
        {1, 0, 2, 9, 6, 3, 7, 8, 4}
    };

    public static void main(String args[]) {
        int numberToFind = checkArgument(args);
        if (numberToFind == -1) {
            System.out.println("Specificy an integer number between 0 and 9");
            return;
        }
        FIRST_LABEL:
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == numberToFind) {
                    System.out.println(numberToFind + " found at row = "
                            + ++i + ", column = " + ++j);
                    break FIRST_LABEL;
                }
            }
        }
        System.out.println("Search completed");
    }

    private static int checkArgument(String[] args) {
        if (args.length == 1) {
            if (args[0].length() == 1) {
                for (int i = 0; i < 10; i++) {
                    if (args[0].equals("" + i)) {
                        return Integer.parseInt(args[0]);
                    }
                }
            }
        }
        return -1;
    }
}