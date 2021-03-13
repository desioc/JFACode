import java.util.*;

public class Exercise10O {
    public static void main(String[] args) {
        Exercise10O exercise10O = new Exercise10O();
        exercise10O.start();
    }
    
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a Kelvin value");
            float kelvin = scanner.nextFloat();
            float celsius = kelvin - 273.15F;
            float fahrenheit = celsius * 9/5 + 32;
            System.out.println(kelvin +"  Kelvin equals:\n" 
                + celsius  +" Celsius\n"
                + fahrenheit +" Fahrenheit");
        }
        catch (InputMismatchException exc) {
            System.out.println("The value must be numeric");
            start();
        }
    }
}