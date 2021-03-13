public interface IDE extends Editor {
    default void compile(SourceFile file) {
        System.out.println("File: "+ file.getName() +" executed!");
    }

    default void execute(SourceFile file) {
        System.out.println("File: "+ file.getName() +" executed!");
    }
}