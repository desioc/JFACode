package com.claudiodesio.jfa;
import static com.claudiodesio.appf.TigerNewFeature.*;

public class JavaProgrammerTest {
    public static void main(String args[]) {
//        JavaProgrammer  pro = new JavaProgrammer("Claudio",
//          TigerNewFeature.VARARGS, TigerNewFeature.FOREACH, 
//          TigerNewFeature.ENUMERATIONS, TigerNewFeature.GENERICS);
        JavaProgrammer pro = new JavaProgrammer("Claudio", VARARGS, FOREACH,
            ENUMERATIONS, GENERICS);
    }
}