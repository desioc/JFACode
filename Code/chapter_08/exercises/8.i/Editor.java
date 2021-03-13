public interface Editor {
    default void save(SourceFile file) {
        System.out.println("File: " + file.getName() + " saved!");
    }
    default void open(SourceFile file) {
        System.out.println("File: " + file.getName() + " open!");
    }
    default void close(SourceFile file) {
        System.out.println("File: " + file.getName() + " closed!");
    }
    default void update(SourceFile file, String testo) {
        System.out.println("File: " + file.getName() + " updated!");
    }
}