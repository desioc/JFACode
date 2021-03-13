import java.util.*;
import java.math.*;

public class Exercise10S {
    private static final String K ="Kelvin";
    private static final String C ="Celsius";
    private static final String F ="Fahrenheit";

    public static void main(String[] args) {
        Exercise10S exercise10S = new Exercise10S();
        exercise10S.start();
    }

    public void start() {
        try {
            Printer.printInstructions();
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
                    Printer.printMessage(value, K, celsius, C, fahrenheit, F);
                    break;
                }
                case"c":
                case"C": {
                    BigDecimal kelvin = Converter.convertCelsiusToKelvin(value);
                    BigDecimal fahrenheit = Converter.convertCelsiusToFahrenheit(value);
                    Printer.printMessage(value, C, kelvin, K, fahrenheit, F);
                    break;
                }
                case"f":
                case"F": {
                    BigDecimal celsius = Converter.convertFahrenheitToCelsius(value);
                    BigDecimal kelvin = Converter.convertFahrenheitToKelvin(value);
                    Printer.printMessage(value, F, celsius, C, kelvin, K);
                    break;
                }
                default:
                Printer.printInvalidScale(scale);
                start();
            }
        } catch (NumberFormatException exc) {
            Printer.printWrongFormat();
            start();
        }
    }
}