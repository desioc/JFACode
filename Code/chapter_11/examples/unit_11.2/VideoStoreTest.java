public class VideoStoreTest {
    public static void main(String args[]) {
        VideoStore videoStore = new VideoStore();
        System.out.println("Nice movies:");
//        Movie[] niceMovies =   videoStore.getNiceMovies();
        Movie[] niceMovies =   videoStore.getFilteredMovies(new MovieFilter() {
            public boolean filter(Movie movie) {
                return movie.getReviewsAverage() >3;
            }
        } );
        printMovies(niceMovies);

        System.out.println("\nSciFi movies:");
//        Movie[] sciFiMovies =   videoStore.getSciFiMovies();
        Movie[] sciFiMovies =   videoStore.getFilteredMovies(new MovieFilter() {
            public boolean filter(Movie movie) {
                return "SciFi".equals(movie.getGenre());
            }
        } );
        printMovies(sciFiMovies);
    }

    private static void printMovies(Movie [] movies) {
        for (Movie movie: movies) {
            if (movie != null) {
                System.out.println(movie);
            }
        }
    }
}