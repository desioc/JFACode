package bookstore.data;

import bookstore.util.*;

public class Book extends Item {
    
    public Book(String isbn, String title, String author, int price, String genre) {
        super(isbn, title, author, price, genre);
    }
    
    public void setGenre(String genre) {
        if (LiteraryGenreUtils.isValidGenre(genre)) {
            super.setGenre(genre);
        } else {
            LiteraryGenreUtils.printError(genre);
        }
    }
    
    @Override
    public String toString() {
        return  "Book" + super.toString();
    }
}