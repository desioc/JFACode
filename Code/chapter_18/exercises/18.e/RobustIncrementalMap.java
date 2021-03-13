package com.claudiodesio.collections;

import java.util.Collection;

public class RobustIncrementalMap<K, V> extends IncrementalMap<K, V> {

    @Override
    protected Collection<V> getCollection() {
        return new RobustSet<>();
    }
    
}