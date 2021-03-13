public class LiteraryGenreUtils extends GenreUtils {
    public static final String ROMANCE = "Romance";
    public static final String ESSAY = "Essay";
    public static final String THRILLER = "Thriller";
    public static final String HANDBOOK = "Handbook";
    public static final String SCIFI = "Scifi";
    public static final String[] genres = { ROMANCE, ESSAY, THRILLER, HANDBOOK, SCIFI };

    public static boolean isValidGenre(String genre) {
        return isValidGenre(genre, genres);
    }

    public static void printError(String genre) {
        printError(genre, genres);
    }
}