public class LocalVariableSyntaxForLambdaParametersTest {
    public static void main(String args[]) {
        VideoStore videoStore = new VideoStore();
        Movie[] niceMovies1 = videoStore.getFilteredMovies((var movie)-> movie.getReviewsAverage() > 3);
        Movie[] niceMovies2 = videoStore.getFilteredMovies((@NonNull var movie)-> movie.getReviewsAverage() > 3);    }
}