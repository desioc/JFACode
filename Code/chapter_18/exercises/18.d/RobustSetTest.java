package com.claudiodesio.test;

import com.claudiodesio.collections.RobustSet;
import com.claudiodesio.excs.DuplicateException;

public class RobustSetTest {
    public static void main(String args[]) {
        RobustSet<String> set = getRobustSet();
        try {
            set.add("Italia");
        } catch (DuplicateException duplicateException) {
            System.out.println(duplicateException.getMessage());
        }
        System.out.println(set);
    }

    public static RobustSet<String> getRobustSet() {
        RobustSet<String> set = new RobustSet<>();
        set.add("Italy");
        set.add("French");
        set.add ("Poland");
        set.add ("Germany");
        set.add ("England");
        set.add ("Spain");
        set.add ("Greece");
        set.add ("Netherlands");
        set.add ("Portugal");
        set.add ("Belgium");
        return set;
    }
}