package com.claudiodesio.test;

import com.claudiodesio.collections.IncrementalMap;
import com.claudiodesio.collections.RobustIncrementalMap;
import com.claudiodesio.excs.DuplicateException;

public class RobustIncrementalMapTest {

    public static void main(String args[]) {
        
        IncrementalMap<Integer, String> map = new RobustIncrementalMap<>();
        IncrementalMapTest.fillIncrementalMap(map);
        try {
            map.add(1, "Greece");
        } catch (DuplicateException duplicatoException) {
            System.out.println(duplicatoException.getMessage());
        }
        System.out.println(map);
    }
}