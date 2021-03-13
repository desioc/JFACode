import java.util.function.Consumer;

public class SocialShowcase {
    public void updateMovie(Movie movie, Consumer<Movie> consumer){
        consumer.accept(movie);
    }
}