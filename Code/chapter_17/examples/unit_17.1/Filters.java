public class Filters {
    public static boolean isNiceMovie(Movie movie) {
        return  movie.getReviewsAverage() > 3;
    }

    public static boolean isSciFiMovie(Movie movie) {
        return "SciFi".equals(movie.getGenre());
    }
}