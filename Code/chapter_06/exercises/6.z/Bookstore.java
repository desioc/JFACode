public class Bookstore {
    private static Bookstore instance;
    private String name;
     private Bookcase[] bookcases;

    public Bookstore() {
        bookcases = new Bookcase[GenreUtils.genres.length];
    }

    public static Bookstore getInstance() {
        if (instance == null) {
            instance = new Bookstore();
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBookcase(Bookcase bookcase) {
        if (bookcases[bookcases.length-1] != null) {
            System.out.println("This bookstore already has all the bookcases!");
            return;
        }
        for (int i = 0; i < bookcases.length; i++) {
            if (bookcases[i] == null) {
                bookcases[i] = bookcase;
                break;
            } else if (bookcases[i].getGenre().equals(bookcase.getGenre())) {
                System.out.println("The "+ bookcase.getGenre()
                +" bookcase already exists!");
                break;
            }
        }
    }

    public Bookcase[] getBookcases() {
        return bookcases;
    }
}