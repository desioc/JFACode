public class Album extends Item {
    public Album(String ismn, String title, String artist, int price, String genre) {
        super(ismn, title, artist, price, genre);
    }
    
    public void setGenre(String genre) {
        if (MusicalGenreUtils.isValidGenre(genre)) {
            super.setGenre(genre);
        } else {
            MusicalGenreUtils.printError(genre);
        }
    }
}