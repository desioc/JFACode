public interface Reader {
    default void read(Book book) {
        System.out.println("I'm reading: " + book.getTitle() + " by " + book.getAuthor());
    }
}