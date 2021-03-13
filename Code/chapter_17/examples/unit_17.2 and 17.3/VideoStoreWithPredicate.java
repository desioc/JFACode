import java.util.function.Predicate;

public class VideoStoreWithPredicate {
    private Movie[] movies;

    public VideoStoreWithPredicate () {
        movies = new Movie[10];
        loadMovies();
    }
    
    public Movie[] getFilteredMovies(Predicate<Movie> MovieFilter) {
        Movie [] filteredMovies = new Movie[10];
        for (int i = 0, j= 0; i< 10; i++) {
            if (MovieFilter.test(movies[i])) {
                filteredMovies[j] = movies[i];
                j++;
            }
        }
        return filteredMovies;
    }

    private void loadMovies() {
        movies[0] = new Movie("Il Signore degli anelli","Fantasy",5);
        movies[1] = new Movie("Star Wars","Fantascienza",5);
        movies[2] = new Movie("Avatar","Fantascienza",3);
        movies[3] = new Movie("Blade Runner","Fantascienza",4);
        movies[4] = new Movie("XMen","Fantascienza",5);
        movies[5] = new Movie("The Avengers","Fantasy",4);
        movies[6] = new Movie("Matrix","Fantascienza",5);
        movies[7] = new Movie("Lanterna Verde","Fantasy",3);
        movies[8] = new Movie("Forrest Gump","Drammatico",5);
        movies[9] = new Movie("Indiana Jones","Avventura",3);
    }
}