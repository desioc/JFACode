package com.claudiodesio.lambda.test;

import com.claudiodesio.lambda.data.City;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise17E {

    public static void main(String args[]) {
        List<City> listOfCities = getCities();
        System.out.println("Cities on the sea: " + filterCities(listOfCities, Exercise17E::isOnTheSea));
        listOfCities = getCities();
        System.out.println("State capitals: " + filterCities(listOfCities, Exercise17E::isStateCapital));
        listOfCities = getCities();
        printDetails(listOfCities, (city) -> System.out.println(city.getName()
                + (city.isStateCapital() ? " is capital state," : "")
                + (city.isOnTheSea() ? " is on the sea," : "")));
    }

    public static List<City> filterCities(List<City> listOfCities, Predicate<City> p) {
        final Iterator<City> iterator = listOfCities.iterator();
        while (iterator.hasNext()) {
            City City = iterator.next();
            if (!p.test(City)) {
                iterator.remove();
            }
        }
        return listOfCities;
    }

    public static void printDetails(List<City> listOfCities, Consumer<City> c) {
        for (City city : listOfCities) {
            c.accept(city);
        }
    }

    private static List<City> getCities() {
        List<City> city = new ArrayList<>();
        city.add(new City("Milano", true, false));
        city.add(new City("Rovigo", false, false));
        city.add(new City("Potenza", true, false));
        city.add(new City("Siracusa", false, true));
        city.add(new City("Perugia", true, false));
        city.add(new City("Napoli", true, true));
        city.add(new City("Pescara", false, true));
        city.add(new City("Taranto", false, true));
        city.add(new City("Siena", false, false));
        return city;
    }
    
    public static boolean isOnTheSea(City city) {
        return city.isOnTheSea();
    }

    public static boolean isStateCapital(City city) {
        return city.isStateCapital();
    }
}