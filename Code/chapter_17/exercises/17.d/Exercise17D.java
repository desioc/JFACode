package com.claudiodesio.lambda.test;

import com.claudiodesio.lambda.data.City;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise17D {

 public static void main(String args[]) {
        List<City> listOfCities = getCities();
        System.out.println("Cities on the sea: " + filterCities(listOfCities, (city) -> city.isOnTheSea()));
        listOfCities = getCities();
        System.out.println("State capitals: " + filterCities(listOfCities,(city) -> city.isStateCapital()));
        listOfCities = getCities();
    }

     public static List<City> filterCities(List<City> listOfCities, Predicate<City> p) {
        final Iterator<City> iterator = listOfCities.iterator();
        while (iterator.hasNext()) {
            City city = iterator.next();
            if (!p.test(city)) {
                iterator.remove();
            }
        }
        return listOfCities;
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
}