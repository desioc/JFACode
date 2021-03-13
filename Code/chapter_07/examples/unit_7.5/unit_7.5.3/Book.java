public class Book {
    private String title;
    private String author;
    private String publisher;
    private int numberOfPages;
    private int price;
    
    public Book (String title, String author){
        this(title); 
        setAuthor(author);
    }
    
    public Book (String title) {
        this.title = title;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}