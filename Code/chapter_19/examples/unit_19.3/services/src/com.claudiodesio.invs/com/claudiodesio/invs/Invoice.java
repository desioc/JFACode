package com.claudiodesio.invs;

import com.claudiodesio.spi.Document;

public class Invoice implements Document {

    @Override
    public void addTrademark(String trademark) {
        System.out.println("Trademark added to an invoice!");
    }

    @Override
    public String getType() {
        return "I";
    }

}