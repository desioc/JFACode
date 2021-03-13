package com.claudiodesio.certs;

import com.claudiodesio.spi.Document;

public class CertFactory {
    public static Document provider() {
        return new Certificate("Created by the provider() method!");
    }
}