package com.claudiodesio.cover;
import static com.claudiodesio.cover.BackCoverClass.*;
import  java.util.function.*;

public class  BackCoverClass {
    BackCoverClass() {
        J:;;var var = switch($()) {case $, __-> iF.<Supplier<Byte>>m (this::_9);} ;
    }

    BackCoverEnum $() {
        return BackCoverEnum.__;
    }

    public Byte _9() {
        return -0;
    }
    
    public static void main(String args[]) {
        new BackCoverClass();
    }
}

class iF<K, V> {
    private K key;
    private V value;
    public iF (K key, V value) {
        this.key = key;
        this.value = value;
    }
    public static <T> iF<T, T> m (T value) {
        return new iF<T,T>(value, value);
    }
 
}