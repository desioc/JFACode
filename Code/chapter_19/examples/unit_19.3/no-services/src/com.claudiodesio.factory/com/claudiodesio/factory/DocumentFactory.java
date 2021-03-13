package com.claudiodesio.factory;

import com.claudiodesio.docs.Certificate;
import com.claudiodesio.docs.Invoice;
import com.claudiodesio.spi.Document;

public class DocumentFactory {

    public static Document getDocument(String documentId) {
        Document document = null;
        switch (documentId) {
            case "I":
                document = new Invoice();
                break;
            case "C":
                document = new Certificate();
                break;
            default:
                break;
        }
        return document;
        
    }
}
