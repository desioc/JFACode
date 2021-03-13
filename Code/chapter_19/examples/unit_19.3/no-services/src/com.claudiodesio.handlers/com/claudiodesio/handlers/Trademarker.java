package com.claudiodesio.handlers;

import com.claudiodesio.factory.DocumentFactory;
import com.claudiodesio.spi.Document;

public class Trademarker {

    public void addTrademark(String documentId, String trademark) {
        Document document  = DocumentFactory.getDocument(documentId);
        document.addTrademark(trademark);
    }

}
