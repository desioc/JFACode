import java.util.*;

public class Exercise4U {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the first operand then press enter.");
        double firstOperand = Double.parseDouble(scanner.nextLine());
        System.out.println("Now choose the operation to perform then press enter:");
        printOperationsTable();
        String operation = scanner.nextLine();
        System.out.println("Now choose the second operand then press enter.");
        double secondOperand = Double.parseDouble(scanner.nextLine());
        double result = performOperation(firstOperand, secondOperand, operation);
        System.out.println("Result = " + result);
    }

    private static double performOperation(double firstOperand, double secondOperand, String operation) {
        SimpleCalc simpleCalc = new SimpleCalc();
        switch (operation) {
            case "+":
                return simpleCalc.sum(firstOperand, secondOperand);
            case "-":
                return simpleCalc.subtract(firstOperand, secondOperand);
            case "x":
                return simpleCalc.multiply(firstOperand, secondOperand);
            case "d":
                return simpleCalc.divide(firstOperand, secondOperand);
            case "r":
                return simpleCalc.returnRest(firstOperand, secondOperand);
            case "u":
                return simpleCalc.maximum(firstOperand, secondOperand);
            case "m":
                return simpleCalc.minimum(firstOperand, secondOperand);
            default:
                System.out.println("The operation specified " + operation + " is invalid");
                System.exit(1);
                return Double.NaN;
        }
    }

    private static void printOperationsTable() {
        System.out.println("'+' : sum");
        System.out.println("'-' : subtract");
        System.out.println("'x' : multiply");
        System.out.println("'d' : divide");
        System.out.println("'r' : return the rest of the division");
        System.out.println("'u' : maximum");
        System.out.println("'m' : minimum");
    }
}