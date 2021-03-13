public class Bookcase {
    private Book[] books;
    private String genre;

    public Bookcase(String genre) {
        books = new Book[100];
        setGenre(genre);
    }

    public void addBook(Book book) {
        if (genre == null) {
            System.out.println("The genre of this bookcase is still not  set"
                +" and books cannot be added!");
            GenreUtils.printError(null);
            return;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("The bookcase is full!");
    }

    public void setBooks(Book[] books) {

    }

    public Book[] getBooks() {
        return books;
    }

    public void setGenre(String genre) {
        if (GenreUtils.isValidGenre(genre)) {
            this.genre = genre;
        } else {
            GenreUtils.printError(genre);
        }
    }

    public String getGenre() {
        return genre;
    }
}