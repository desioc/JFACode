import java.util.*;
import java.math.*;

public class Exercise10R {
    public static void main(String[] args) {
        Exercise10R exercise10R = new Exercise10R();
        exercise10R.start();
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
                case"K": {
                    BigDecimal celsius = Converter.convertKelvinToCelsius(value);
                    BigDecimal fahrenheit = Converter.convertKelvinToFahrenheit(value);
                    System.out.println(value +" Kelvin equals:\n"
                    + celsius  +" Celsius\n"+ fahrenheit +" Fahrenheit");
                    break;
                }
                case"c":
                case"C": {
                    BigDecimal kelvin = Converter.convertCelsiusToKelvin(value);
                    BigDecimal fahrenheit = Converter.convertCelsiusToFahrenheit(value);
                    System.out.println(value +" Celsius equals:\n"
                        + kelvin  +" Kelvin\n"+ fahrenheit +" Fahrenheit");
                    break;
                }
                case"f":
                case"F": {
                    BigDecimal celsius = Converter.convertFahrenheitToCelsius(value);
                    BigDecimal kelvin = Converter.convertFahrenheitToKelvin(value);
                    System.out.println(value + " Fahrenheit equals:\n"
                        + celsius  +" Celsius\n"+ kelvin +" Kelvin");
                    break;
                }
                default:
                    System.out.println("Invalid scale "  + scale + ". Use K for Kelvin, C for Celsius, F for Fahrenheit");
                start();
            }
        }
        catch (NumberFormatException exc) {
            System.out.println("Wrong format!");
            start();
        }
    }
}