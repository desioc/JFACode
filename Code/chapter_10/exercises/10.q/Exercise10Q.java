import java.util.*;
import java.math.*;

public class Exercise10Q {
    public static void main(String[] args) {
        Exercise10Q exercise10Q = new Exercise10Q();
        exercise10Q.start();
    }

    public void start() {
        try {
            System.out.println("Enter a value in Kelvin (for example 12K), Celsius (25C) or Fahrenheit (451F)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            int lastCharIndex = input.length()-1;
            BigDecimal value = new BigDecimal(input.substring(0, lastCharIndex));
            String scale = input.substring(lastCharIndex);
            switch(scale) {
                case"k":
                case"K":
                {
                    BigDecimal celsius = value.subtract(BigDecimal.valueOf(273.15));
                    BigDecimal fahrenheit = celsius.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(5), 2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(32));
                    System.out.println(value +" Kelvin equals:\n"
                        + celsius  +" Celsius\n"+ fahrenheit +" Fahrenheit");
                    break;
                }
                case"c":
                case"C":
                {
                    BigDecimal kelvin = value.add(BigDecimal.valueOf(273.15));
                    BigDecimal fahrenheit = value.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(5),2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(32));
                    System.out.println(value +" Celsius equals:\n"
                        + kelvin  +" Kelvin\n"+ fahrenheit +" Fahrenheit");
                    break;
                }
                case"f":
                case"F":
                {
                    BigDecimal celsius = value.subtract(BigDecimal.valueOf(32)).multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(9), 2, RoundingMode.HALF_UP);
                    BigDecimal kelvin = celsius.add(BigDecimal.valueOf(273.15));
                    System.out.println(value + " Fahrenheit equals:\n"
                        + celsius  +" Celsius\n"+ kelvin +" Kelvin");
                    break;
                }
                default:
                    System.out.println("Invalid scale "  + scale + ". Use K for Kelvin, C for Celsius, F for Fahrenheit");
                    start();
            }
        } catch (NumberFormatException exc) {
            System.out.println("Wrong format!");
            start();
        }
    }
} 