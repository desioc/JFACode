package com.claudiodesio.collections;

import com.claudiodesio.excs.DuplicateException;
import java.util.HashSet;

public class RobustSet<E> extends HashSet<E> {

    @Override
    public boolean add(E e) {
        boolean result = super.add(e);
        if (!result) {
            throw new DuplicateException(e);
        }
        return result;
    }

}