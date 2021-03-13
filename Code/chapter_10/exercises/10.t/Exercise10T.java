import java.util.*;
import java.io.*;
import java.math.*;
import java.util.logging.*;

public class Exercise10T {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("Exercise10T");
    private static final String K ="Kelvin";
    private static final String C ="Celsius";
    private static final String F ="Fahrenheit";

    public static void main(String[] args) {
        initLogging();
        LOGGER.info("Main() method called");
        Exercise10T exercise10T = new Exercise10T();
        exercise10T.start();
        LOGGER.info("Program terminated");
    }

    private static void initLogging() {
        try {
            logManager.readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE,"Problem reading configuration file",exception);
        }
    }

    public void start() {
        try {
            LOGGER.info("Start() method called");
            Printer.printInstructions();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            int lastCharIndex = input.length()-1;
            BigDecimal value = new BigDecimal(input.substring(0, lastCharIndex));
            String scale = input.substring(lastCharIndex);
            switch(scale) {
                case"k":
                case"K": {
                    LOGGER.fine("Kelvin scale in use");
                    BigDecimal celsius = Converter.convertKelvinToCelsius(value);
                    BigDecimal fahrenheit = Converter.convertKelvinToFahrenheit(value);
                    Printer.printMessage(value, K, celsius, C, fahrenheit, F);
                    break;
                }
                case"c":
                case"C": {
                    LOGGER.fine("Celsius scale in use");
                    BigDecimal kelvin = Converter.convertCelsiusToKelvin(value);
                    BigDecimal fahrenheit = Converter.convertCelsiusToFahrenheit(value);
                    Printer.printMessage(value, C, kelvin, K, fahrenheit, F);
                    break;
                }
                case"f":
                case"F": {
                    LOGGER.fine("Fahrenheit scale in use");
                    BigDecimal celsius = Converter.convertFahrenheitToCelsius(value);
                    BigDecimal kelvin = Converter.convertFahrenheitToKelvin(value);
                    Printer.printMessage(value, F, celsius, C, kelvin, K);
                    break;
                }
                default:
                LOGGER.fine("Invalid scale");
                Printer.printInvalidScale(scale);
                start();
            }
        } catch (NumberFormatException exc) {
            LOGGER.severe(exc.getMessage());
            Printer.printWrongFormat();
            start();
        }
    }
}