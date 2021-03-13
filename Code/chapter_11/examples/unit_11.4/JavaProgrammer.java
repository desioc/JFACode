package com.claudiodesio.jfa;
import java.util.*;

public class JavaProgrammer {
    private List updates;
    
    private String name;
    
    public JavaProgrammer(String name, TigerNewFeature... features) {
        this.name = name;
        updates = new ArrayList();
        addUpdates(features);
    }
    //...
    public void addUpdates(TigerNewFeature... features) {
        for (TigerNewFeature update : features) {
            updates.add(update);
        }
    }
}