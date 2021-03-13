import java.util.*;

public class Exercise4Z {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type an operand, then press enter (add other operands repeating this operation)."
                + "\nWhen you are finished choose the operation to be performed, then press enter.");
        printOperationsTable();
        String temp;
        String operandsString = "";
        while (isNotOperation(temp = scanner.nextLine())) {
            operandsString += temp + "-";
        }
        if (isNotOperation(temp)) {
            System.out.println("Operation code error!");
        }
        String[] operandsArray = operandsString.split("-");
        double[] operands = new double[operandsArray.length];
        for (int i = 0; i < operandsArray.length; i++) {
            operands[i] = Double.parseDouble(operandsArray[i]);
        }
        double risultato = performOperation(operands, temp);
        System.out.println("Result = " + risultato);
    }

    private static boolean isNotOperation(String line) {
        if (line.equals("+") || line.equals("x") || line.equals("u") || line.equals("m")) {
            return false;
        }
        return true;
    }

    private static double performOperation(double[] operands, String operation) {
        StrangeCalc strangeCalc = new StrangeCalc();
        switch (operation) {
            case "+":
                return strangeCalc.sum(operands);
            case "x":
                return strangeCalc.multiply(operands);
            case "u":
                return strangeCalc.maximum(operands);
            case "m":
                return strangeCalc.minimum(operands);
            default:
                System.out.println("Operation specified " + operation + " invalid!");
                System.exit(1);
                return Double.NaN;
        }
    }

    private static void printOperationsTable() {
        System.out.println("'+' : sum");
        System.out.println("'x' : multiply");
        System.out.println("'u' : maximum");
        System.out.println("'m' : minimum");
    }
}