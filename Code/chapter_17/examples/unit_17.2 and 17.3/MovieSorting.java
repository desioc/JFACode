public class MovieSorting {
    public int sortByName(Movie movie1, Movie movie2) {
        return movie1.getName().compareTo(movie2.getName());
    }

    public int sortByReviewsAverage(Movie movie1, Movie movie2) {
        Integer reviewsAverageMovie1 = new Integer(movie1.getReviewsAverage());
        Integer reviewsAverageMovie2 = new Integer(movie2.getReviewsAverage());
        return reviewsAverageMovie2.compareTo(reviewsAverageMovie1);
    }
}