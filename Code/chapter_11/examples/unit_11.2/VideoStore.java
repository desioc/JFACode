public class VideoStore {
    private Movie[] movies;

    public VideoStore() {
        movies = new Movie[10];
        loadMovies();
    }
    public void setFilms(Movie[] movies) {
        this.movies = movies;
    }

    public Movie[] getFilms() {
        return movies;
    }

    public Movie[] getSciFiMovies() {
        Movie [] sciFiMovies = new Movie[10];
        for (int i = 0, j= 0; i< 10;i++) {
            if ("SciFi".equals(movies[i].getGenre())) {
                sciFiMovies[j] = movies[i];
                j++;
            }
        }
        return sciFiMovies;
    }

    public Movie[] getNiceMovies() {
        Movie [] niceMovies = new Movie[10];
        for (int i = 0, j= 0; i< 10;i++) {
            if (movies[i].getReviewsAverage() > 3) {
                niceMovies[j] = movies[i];
                j++;
            }
        }
        return niceMovies;
    }

    public Movie[] getFilteredMovies(MovieFilter movieFilter) {
        Movie [] filteredMovies = new Movie[10];
        for (int i = 0, j= 0; i< 10;i++) {
            if (movieFilter.filter(movies[i])) {
                filteredMovies[j] = movies[i];
                j++;
            }
        }
        return filteredMovies;
    }

    private void loadMovies() {
        movies[0] = new Movie("The Lord of the Rings","Fantasy",5);
        movies[1] = new Movie("Star Wars","SciFi",5);
        movies[2] = new Movie("Avatar","SciFi",3);
        movies[3] = new Movie("Blade Runner","SciFi",4);
        movies[4] = new Movie("XMen","SciFi",5);
        movies[5] = new Movie("The Avengers","Fantasy",4);
        movies[6] = new Movie("Matrix","SciFi",5);
        movies[7] = new Movie("Green lantern","Fantasy",3);
        movies[8] = new Movie("Forrest Gump","Drama",5);
        movies[9] = new Movie("Indiana Jones","Adventure",3);
    }
}