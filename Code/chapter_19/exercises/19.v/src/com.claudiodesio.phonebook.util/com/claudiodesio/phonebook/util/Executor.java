package com.claudiodesio.phonebook.util;

@FunctionalInterface
public interface Executor {

    void execute() throws Exception;
}