import java.util.*;

public class VideoStoreWithLambdaTest {
    public static void main(String args[]) {
        VideoStore videoStore = new VideoStore();
        System.out.println("Nice movies:");
//        movie[] niceMovies =   videoStore.getNiceMovies();
       /* movie[] sciFiMovies =   videoStore.getFilteredMovies(new MovieFilter() {
           @Override
            public boolean filter(Movie movie) {
                return movie.getMediaRecensioni() >3;
            }
        }); */
        Movie[] niceMovies = videoStore.getFilteredMovies(movie-> movie.getReviewsAverage() >3);
        printMovie(niceMovies);
        System.out.println("\nFilm di Fantascienza:");
//        movie[] sciFiMovies =   videoStore.getFilmDiFantascienza();
       /* movie[] sciFiMovies =   videoStore.getFilteredMovie(new FiltroFilm() {
           @Override
            public boolean filter(movie movie) {
                return"Fantascienza".equals(movie.getGenere());
            }
        }); */
        Movie[] sciFiMovies = videoStore.getFilteredMovies(movie->"SciFi".equals(movie.getGenre()));
        printMovie(sciFiMovies);

        System.out.println("\nMovie that ends with s:");
        Movie[] moviesThatEndsWithS  = videoStore.getFilteredMovies(movie->movie.getName().endsWith("s"));
        printMovie(moviesThatEndsWithS);

        System.out.println("\nSciFi movies filtered with a static method reference:");
        System.out.println("\nSciFi Movie:");
        sciFiMovies = videoStore.getFilteredMovies(Filters::isSciFiMovie);
        printMovie(sciFiMovies);
        //Reference to methods        
        System.out.println("\nNice movie filtered witha lambda used by the Filters method:");
        System.out.println("\nSciFiMovie:");
        sciFiMovies = videoStore.getFilteredMovies(movie->Filters.isNiceMovie(movie));
        printMovie(sciFiMovies);

        Movie[] movies = videoStore.getMovies();
        System.out.println("\nMovies ordered by monitor with a instance method reference :");
        MovieSorting movieSorting = new MovieSorting();
        /* Arrays.sort(movies, (Movie movie1, Movie movie2)-> movie1.getName().compareTo(movie2.getName())); */
        Arrays.sort(movies, movieSorting::sortByName); 
        printMovie(movies);

        System.out.println("\nMovies ordered by reviews average with an instance method reference :");
        Arrays.sort(movies, movieSorting::sortByReviewsAverage);
        printMovie(movies);        

        System.out.println("\nMovies ordered by strings, ordered with klowercase character" + 
        "con un instance method of an arbitrary object of a type reference :");
        List<String> movieNames = new ArrayList<String>();
        for(Movie movie:movies) {
            movieNames.add(movie.getName());
        }
//        Collections.sort(movieNames, (s1,s2)->s1.compareToIgnoreCase(s2));
        Collections.sort(movieNames, String::compareToIgnoreCase);
        printMovie(movies); 
        
        String s1 = "Rosalia";
        String s2 = "rosalia";
        System.out.println("\nRosalia vs rosalia = "+ s1.compareToIgnoreCase(s2));
    }

    private static void printMovie(Movie [] movies) {
        for (Movie movie: movies) {
            if (movie != null) {
                System.out.println(movie);
            }
        }
    }
}