package com.claudiodesio.certs;

import com.claudiodesio.spi.Document;

class Certificate implements Document {
    private String text;

    public Certificate(String text) {
        this.text = text;
    }

    @Override
    public void addTrademark(String trademark) {
        System.out.println("Trademark added to a certificate!");
    }

    @Override
    public String getType() {
        return"C";
    }

    public String toString() {
        return text;
    }
}