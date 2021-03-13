public class GenreUtils {
    public static final String ROMANCE = "Romance";
    public static final String ESSAY = "Essay";
    public static final String THRILLER = "Thriller";
    public static final String HANDBOOK = "Handbook";
    public static final String SCIFI = "Scifi";
    public static final String[] genres = { ROMANCE, ESSAY, THRILLER, HANDBOOK, SCIFI };

    public static boolean isValidGenre(String genre) {
        boolean validGenre = false;
        for (String fixedGenre : genres) {
            if (fixedGenre.equals(genre)) {
                validGenre = true;
                break;
            }
        }
        return validGenre;
    }

    public static void printError(String genre) {
        System.out.println("Genre " + genre + " not valid! Please, use one of the following genres:");
        for (String fixedGenre : genres) {
            System.out.println(fixedGenre);
        }
    }
}