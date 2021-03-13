package com.claudiodesio.factory;

import com.claudiodesio.spi.Document;
import java.util.Iterator;
import java.util.ServiceLoader;

public class DocumentFactory {

    public static Document getDocument(String documentId) {
        ServiceLoader<Document> serviceLoader = ServiceLoader.load(com.claudiodesio.spi.Document.class);
        for (Document document : serviceLoader) {
            if (document.getType().equals(documentId)) {
                return document;
            }
        }
        throw new IllegalArgumentException("No document found with ID=" + documentId);
    }
}