import java.util.*;
import java.math.*;

public class Exercise10P {
    public static void main(String[] args) {
        Exercise10P exercise10P = new Exercise10P();
        exercise10P.start();
    }
    
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a Kelvin value");
            BigDecimal kelvin = scanner.nextBigDecimal();
            BigDecimal celsius = kelvin.subtract(BigDecimal.valueOf(273.15));
            BigDecimal fahrenheit = celsius.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(5)).add(BigDecimal.valueOf(32));
            System.out.println(kelvin +" Kelvin equals:\n"
            + celsius  +" Celsius\n" + fahrenheit +" Fahrenheit");
        } catch (InputMismatchException exc) {
            System.out.println("The value must be numeric");
            start();
        }
    }
}