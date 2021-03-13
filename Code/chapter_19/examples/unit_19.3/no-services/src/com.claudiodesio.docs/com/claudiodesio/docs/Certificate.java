package com.claudiodesio.docs;

import com.claudiodesio.spi.Document;

public class Certificate implements Document {

    @Override
    public void addTrademark(String trademark) {
        System.out.println("Trademark added to a certificate!");
    }

}