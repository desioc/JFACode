public class BookstoreTest {
    public static void main(String[] args) {
        Book jfaVol1 = new Book("979-12-200-4915-3", "Java for Aliens Vol. 1", "Claudio De Sio Cesari", 25, GenreUtils.HANDBOOK);
        Book jfaVol2 = new Book("979-12-200-4916-0", "Java for Aliens Vol. 2", "Claudio De Sio Cesari", 25, GenreUtils.HANDBOOK);
        Book f451 = new Book("978-88-046-6529-8", "Fahrenheit 451", "Ray Bradbury", 10, GenreUtils.SCIFI);
        Book shining = new Book("978-88-452-9530-0", "Shining", "Stephen King", 12, GenreUtils.THRILLER);
        Book tkr = new Book("978-88-683-6730-5", "The Kite Runner", "Khaled Hosseini", 11, GenreUtils.ROMANCE);
        Book ttoe = new Book("978-88-170-7976-1", "The Theory of Everything", "Stephen Hawking", 10, GenreUtils.ESSAY);
        Bookcase handbookBookcase = new Bookcase(GenreUtils.HANDBOOK);
        Bookcase scifiBookcase = new Bookcase(GenreUtils.SCIFI);
        Bookcase scifiBookcase2 = new Bookcase(GenreUtils.SCIFI);
        Bookcase thrillerBookcase = new Bookcase(GenreUtils.THRILLER);
        Bookcase romanceBookcase = new Bookcase(GenreUtils.ROMANCE);
        Bookcase essaysBookcase = new Bookcase(GenreUtils.ESSAY);
        Bookcase essaysBookcase2 = new Bookcase(GenreUtils.ESSAY);
        handbookBookcase.addBook(jfaVol1);
        handbookBookcase.addBook(jfaVol2);
        scifiBookcase.addBook(f451);   
        thrillerBookcase.addBook(shining);
        romanceBookcase.addBook(tkr);
        essaysBookcase.addBook(ttoe);
        Bookstore bookstore = Bookstore.getInstance();
        bookstore.setName("Bookstore for aliens");
        bookstore.addBookcase(handbookBookcase);
        bookstore.addBookcase(scifiBookcase);
        bookstore.addBookcase(scifiBookcase2);
        bookstore.addBookcase(thrillerBookcase);
        bookstore.addBookcase(romanceBookcase);
        bookstore.addBookcase(essaysBookcase);
        bookstore.addBookcase(essaysBookcase2);
        Bookcase[] bookcases = bookstore.getBookcases();
        System.out.println("Bookstore list of bookcases:");
        for (Bookcase bookcase : bookcases) {
            System.out.println("Bookcase " + bookcase.getGenre() + ":");
            Book[] books = bookcase.getBooks();
            for (Book book : books) {
                if (book != null) {
                    System.out.println("\t" + book.getTitle() + " by " + book.getAuthor() + " (Genre " + book.getGenre() + ")");
                }
            }
        }
    }
}