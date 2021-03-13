package bookstore.util;

public class MusicalGenreUtils extends GenreUtils {
    public static final String ROCK = "Rock";
    public static final String JAZZ = "Jazz";
    public static final String BLUES = "Blues";
    public static final String POP = "Pop";
    public static final String RAP = "Rap";
    public static final String[] genres = { ROCK, JAZZ, BLUES, POP, RAP };
    
    public static boolean isValidGenre(String genre) {
        return isValidGenre(genre, genres);
    }
    
    public static void printError(String genre) {
        printError(genre, genres);
    }
}