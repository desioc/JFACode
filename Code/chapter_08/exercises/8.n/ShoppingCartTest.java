package bookstore.test;
import bookstore.data.*;
import bookstore.util.*;

public class ShoppingCartTest {
    public static void main(String[] args) {
        Book jfaVol1 = new Book("979-12-200-4915-3","Java for Aliens Vol. 1","Claudio De Sio Cesari", 25, LiteraryGenreUtils.HANDBOOK);
        Book jfaVol2 = new Book("979-12-200-4916-0","Java for Aliens Vol. 2","Claudio De Sio Cesari", 25, LiteraryGenreUtils.HANDBOOK);
        Album lad = new Album("979-0-236-44-3","Live after Death","Iron Maiden", 25, MusicalGenreUtils.ROCK);
        Album mop = new Album("978-0-789-01-2","Master of Puppets","Metallica", 25, MusicalGenreUtils.ROCK);
        Album tt = new Album("978-0-789-01-9","Tokyo Tapes","Scorpions", 22, MusicalGenreUtils.ROCK);
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("ShoppingCart empty = " + shoppingCart.isEmpty());
        System.out.println("Adding the book "+ jfaVol1);
        shoppingCart.add(jfaVol1);
        System.out.println("Adding the book "+ jfaVol2);
        shoppingCart.add(jfaVol2);
        System.out.println("Adding the album "+ lad);
        shoppingCart.add(lad);
        System.out.println("Adding the album "+ mop);
        shoppingCart.add(mop);
        System.out.println("Adding the album "+ tt);
        shoppingCart.add(tt);
        System.out.println("ShoppingCart Empty = " + shoppingCart.isEmpty());
        System.out.println(shoppingCart);
    }
}