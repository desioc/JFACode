package com.claudiodesio.frontoffice.data;

public class Applicant extends Thread {

    public Applicant(String name) {
        setName(name);
    }

    @Override
    public void run() {
        FrontOffice.getInstance().handleRequest(this);
    }

    @Override
    public String toString() {
        return getName();
    }
}