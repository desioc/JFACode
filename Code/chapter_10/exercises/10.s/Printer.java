import java.math.*;

public class Printer {
    public static void printInstructions() {
        System.out.println("Enter a value in Kelvin (for example 12K), Celsius (25C) or Fahrenheit (451F)");
    }

    public static void printMessage(BigDecimal value1, String scale1,BigDecimal value2, String scale2,BigDecimal value3, String scale3) {
        System.out.println(value1 +" "+ scale1+" equals:\n"
        + value2 +" "+ scale2 +"\n"+ value3 +" "+ scale3);
    }

    public static void printInvalidScale(String scale) {
        System.out.println("Invalid scale "+ scale +". Use K for Kelvin, C for Celsius, F for Fahrenheit");
    }

    public static void printWrongFormat() {
        System.out.println("Wrong formato!");
    }
}