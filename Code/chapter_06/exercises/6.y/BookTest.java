public class BookTest {
    public static void main(String[] args) {
        Book jfaVol1 = new Book("979-12-200-4915-3", "Java for Aliens Vol. 1", "Claudio De Sio Cesari", 25, "Handbook");
        Book jfaVol2 = new Book("979-12-200-4916-0", "Java for Aliens Vol. 2", "Claudio De Sio Cesari", 25, "Biography");
        System.out.println("JFA Vol 1 Genre = " + jfaVol1.getGenre());
        System.out.println("JFA Vol 2 Genre = " + jfaVol2.getGenre());
    }
}