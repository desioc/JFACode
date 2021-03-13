public class GenreUtils {

    public static boolean isValidGenre(String genre, String[] validGenres) {
        boolean validGenre = false;
        for (String fixedGenre : validGenres) {
            if (fixedGenre.equals(genre)) {
                validGenre = true;
            }
        }
        return validGenre;
    }

    public static void printError(String genre, String[] validGenres) {
        System.out.println("Genre " + genre + " not valid! Please, use one of the following genres:");
        for (String fixedGenre : validGenres) {
            System.out.println(fixedGenre);
        }
    }
}