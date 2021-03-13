package com.claudiodesio.test;

import com.claudiodesio.collections.IncrementalMap;
import com.claudiodesio.collections.RobustSet;
import java.util.Iterator;

public class IncrementalMapTest {

    public static void main(String args[]) {
        IncrementalMap<Integer, String> map = new IncrementalMap<>();
        fillIncrementalMap(map);
        System.out.println(map);
    }

    public static void fillIncrementalMap(IncrementalMap<Integer, String> map) {
        RobustSet<String> set = RobustSetTest.getRobustSet();
        int i = 1;
        int j = 1;
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (i % 3 == 0) {
                j++;
            }
            String string = iterator.next();
            map.add(j, string);
            i++;
        }
    }
}