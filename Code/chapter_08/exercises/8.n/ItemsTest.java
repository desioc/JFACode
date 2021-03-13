package bookstore.test;

import bookstore.data.*;
import bookstore.util.*;

public class ItemsTest {
    public static void main(String[] args) {
        Book jfaVol1 = new Book("979-12-200-4915-3","Java for Aliens Vol. 1","Claudio De Sio Cesari", 25, LiteraryGenreUtils.HANDBOOK);
        Book jfaVol2 = new Book("979-12-200-4916-0","Java for Aliens Vol. 2","Claudio De Sio Cesari", 25,"NonExisting");
//        System.out.println("Genre JFA Vol 1 = " + jfaVol1.getGenre());
//        System.out.println("Genre JFA Vol 2 = " + jfaVol2.getGenre());
        System.out.println(jfaVol1);
        System.out.println(jfaVol2);
        Album lad = new Album("979-0-236-44-3","Live after Death","Iron Maiden", 25, MusicalGenreUtils.ROCK);
        Album mop = new Album("978-0-789-01-2","Master of Puppets","Metallica", 25,"NonExisting");
//        System.out.println("Genre Live after Death = "+ lad.getGenre());
//        System.out.println("Genre Master of Puppets = "+ mop.getGenre());
        System.out.println(lad);
        System.out.println(mop);
    }
}