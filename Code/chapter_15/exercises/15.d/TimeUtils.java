package com.claudiodesio.frontoffice.data;

import java.util.*;

public class TimeUtils {

    private static final Random RANDOM = new Random();

    public static int getRandomNumber() {
        return (RANDOM.nextInt(6) + 5);
    }
}