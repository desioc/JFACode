public class Movie {
    private String name;
    private String genre;
    private int reviewsAverage;

    public Movie (String name, String genre, int reviewsAverage) {
        this.name = name;
        this.genre = genre;
        this.reviewsAverage = reviewsAverage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setReviewsAverage(int reviewsAverage) {
        this.reviewsAverage = reviewsAverage;
    }

    public int getReviewsAverage() {
        return reviewsAverage;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    
    public String toString(){
        return getName();
    }
}