public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String genre;
    public static final String [] genres = {"Romance", "Essay", "Thriller", "Handbook"}; 

    public Book(String isbn, String title, String author, int price, String genre) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setGenre(genre);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String title) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        for (String validGenre : genres) {
            if (validGenre.equals(genre)) {
                this.genre = genre;
                return;
            }
        }
        System.out.println("Genre " + genre + " not valid! Please, use one of the following genres:");
        for (String validGenre : genres) {
            System.out.println(validGenre);    
        }
    }
}