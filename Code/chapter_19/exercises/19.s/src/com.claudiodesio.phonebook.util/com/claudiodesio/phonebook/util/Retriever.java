package com.claudiodesio.phonebook.util;

@FunctionalInterface
public interface Retriever<O> {

    O execute() throws Exception;
}