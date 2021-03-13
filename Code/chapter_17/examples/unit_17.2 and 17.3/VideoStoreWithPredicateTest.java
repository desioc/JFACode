import java.util.function.Predicate;
public class VideoStoreWithPredicateTest {
    public static void main(String args[]) {
        VideoStoreWithPredicate videostore = new VideoStoreWithPredicate();
        System.out.println("Nice movies:");

        Movie[] niceMovies = videostore.getFilteredMovies((Movie movie)-> movie.getReviewsAverage() >3);
        stampaMovie(niceMovies);
        System.out.println("\nSciFI movies:");
        Movie[] filmDiFantascienza = videostore.getFilteredMovies((Movie movie)->"SciFi".equals(movie.getGenre()));
        stampaMovie(filmDiFantascienza);
        System.out.println("\nNice SciFI movies:");
        Predicate<Movie> predicateSciFiMovie = (Movie movie)->"SciFi".equals(movie.getGenre());
        Predicate<Movie> predicateNiceMovies = (Movie movie)-> movie.getReviewsAverage() >3;
        Movie[] niceSciFiMovies = videostore.getFilteredMovies(predicateSciFiMovie.and(predicateNiceMovies));
        stampaMovie(niceSciFiMovies);
    }
    private static void stampaMovie(Movie [] movies) {
        for (Movie Movie: movies) {
            if (Movie != null) {
                System.out.println(Movie);
            }
        }
    }
}