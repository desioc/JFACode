import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String args[]) {
        VideoStore videostore = new VideoStore();
        SocialShowcase shocase = new SocialShowcase();
        Movie movies[] = videostore.getMovies();
        Movie greenLantern =  movies[7];
        shocase.updateMovie(greenLantern, movie -> movie.setReviewAverage(5));
        System.out.printf("The review average %s has been update to %s", greenLantern.getName(), greenLantern.getReviewAverage());

        Movie starWarsEpisode1 =  movies[1];
        Consumer<Movie> updateConsumerVote = movie -> movie.setReviewAverage(3);
        Consumer<Movie> updateConsumerName = movie -> movie.setName("Star Wars Episode 1 - The Phantom Menace");
        shocase.updateMovie(starWarsEpisode1, updateConsumerName.andThen(updateConsumerVote));
        System.out.printf("\nThe review average %s has been update to %s", starWarsEpisode1.getName(), starWarsEpisode1.getReviewAverage());

    }
}