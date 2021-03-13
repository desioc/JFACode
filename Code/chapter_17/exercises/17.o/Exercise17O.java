package com.claudiodesio.lambda.test;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise17O {
    static String names[] = {"Clarissa","Jem","Top","Ermeringildo","Iamaca",
        "Tom","Arlequin","Francesca","Cumbus","Blue"
    } ;

    static int compareLength(String first, String second) {
        return -(Integer.compare(first.length(), second.length()));
    }

    static int compareReverseLength(String first, String second) {
        return (Integer.compare(first.length(), second.length()));
    }

    static int compareReverseAlphabet(String first, String second) {
        return -(first.compareTo(second));
    }

    static int compareLengthAndReverseAlphabet(String first, String second) {
        int result = -Integer.compare(first.length(),
        second.length());
        if (result == 0) {
            result = first.compareTo(second);
        }
        return result;
    }

    public static void main(String args[]) {
       
        Arrays.sort(names, Exercise17O::compareLength);
        System.out.println("Names sorted by length: "+
            Arrays.asList(names));

        Arrays.sort(names, Exercise17O::compareReverseLength);
        System.out.println("Names sorted by length in reverse: "+
            Arrays.asList(names));

        Arrays.sort(names, String::compareTo);
        System.out.println("Names in alphabetical order : "+ Arrays.asList(names));

        Arrays.sort(names, Exercise17O::compareReverseAlphabet);
        System.out.println("Names in reverse alphabetical order "+
            Arrays.asList(names));

        Arrays.sort(names, Exercise17O::compareLengthAndReverseAlphabet);
        System.out.println(
            "Names sorted by length in reverse and in alphabetical order: "
                + Arrays.asList(names));
    }
}