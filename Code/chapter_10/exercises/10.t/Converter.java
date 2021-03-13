import java.math.*;

public class Converter {
    public static BigDecimal convertKelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(BigDecimal.valueOf(273.15));
    }
    
    public static BigDecimal convertKelvinToFahrenheit(BigDecimal kelvin) {
        BigDecimal celsius = convertKelvinToCelsius(kelvin);
        return celsius.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(5), 2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(32));
    }
    
    public static BigDecimal convertCelsiusToKelvin(BigDecimal celsius) {
        return celsius.add(BigDecimal.valueOf(273.15));
    }
    
    public static BigDecimal convertCelsiusToFahrenheit(BigDecimal celsius) {
        return celsius.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(5),2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(32));
    }
    
    public static BigDecimal convertFahrenheitToKelvin(BigDecimal fahrenheit) {
        BigDecimal celsius = convertFahrenheitToCelsius(fahrenheit);
        return celsius.add(BigDecimal.valueOf(273.15));
    }
    
    public static BigDecimal convertFahrenheitToCelsius(BigDecimal fahrenheit) {
        return fahrenheit.subtract(BigDecimal.valueOf(32)).multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(9), 2, RoundingMode.HALF_UP);
    }
}