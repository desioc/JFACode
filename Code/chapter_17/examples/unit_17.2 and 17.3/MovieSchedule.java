import java.time.*;

public class MovieSchedule {

    private Movie movie;
    private LocalDate date;
    private LocalTime time;
    
    public MovieSchedule (Movie movie, LocalDate date, LocalTime time){
        this.movie = movie;
        this.date = date;
        this.time = time;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
    
    public String toString(){
        return movie.getName() + " will be projected projectedl on " + getDate() + " at " + getTime();
    }
}