package com.claudiodesio.test;

import com.claudiodesio.collections.RobustSet;
import com.claudiodesio.data.City;

public class StreamsTest {

    public static void main(String args[]) {
        RobustSet<City> set = getRobustSet();
        System.out.println("City on the sea:");
        set.stream().filter(e->e.isOnTheSea()).forEach(System.out::println);
        System.out.println("\nState capital:");
        set.stream().filter(e->e.isStateCapital()).forEach(System.out::println);
        System.out.println("\nCities whose name ends with 'a':");
        set.stream().filter(e->e.getName().endsWith("a")).forEach(System.out::println);
    }

    public static RobustSet<City> getRobustSet() {
        RobustSet<City> set = new RobustSet<>();
        set.add(new City("Milano", true, false));
        set.add(new City("Rovigo", false, false));
        set.add(new City("Potenza", true, false));
        set.add(new City("Siracusa", false, true));
        set.add(new City("Perugia", true, false));
        set.add(new City("Napoli", true, true));
        set.add(new City("Pescara", false, true));
        set.add(new City("Taranto", false, true));
        set.add(new City("Siena", false, false));
        return set;
    }
}