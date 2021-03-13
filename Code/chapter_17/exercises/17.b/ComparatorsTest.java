package com.claudiodesio.lambda.test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorsTest {
    
    static String names[] = {"Clarissa", "Jem", "Top", "Ermeringildo", 
            "Iamaca", "Tom", "Arlequin", "Francesca", "Cumbus", "Blue"};

    public static void main(String args[]) {
        Comparator<String> lenghtComparator = (first, second)
                -> -(Integer.compare(first.length(), second.length()));

        Comparator<String> reverseLengthComparator = (first, second)
                -> (Integer.compare(first.length(), second.length()));

        Comparator<String> reverseAlphabetComparator = (first, second)
                -> -(first.compareTo(second));

        Comparator<String> lengthAndReverseAlphabetComparator = (first, second)
                -> {
                    int result = -Integer.compare(first.length(), second.length());
                    if (result == 0) {
                        result = first.compareTo(second);
                    }
                    return result;
                };
        Arrays.sort(names, lenghtComparator);
        System.out.println("Names sorted by length: " + Arrays.asList(names));

        Arrays.sort(names, reverseLengthComparator);
        System.out.println("Names sorted by length in reverse: " + Arrays.asList(names));

        Arrays.sort(names, String::compareTo);
        System.out.println("Names sorted by  alphabetical order: " + Arrays.asList(names));

        Arrays.sort(names, reverseAlphabetComparator);
        System.out.println("Names sorted by  reverse alphabetical order: " + Arrays.asList(names));

        Arrays.sort(names, lengthAndReverseAlphabetComparator);
        System.out.println("Names sorted by length in reverse and in alphabetical order: " + Arrays.asList(names));
    }
}