public class IDETest {
    public static void main(String args[]) {
        IDE ide = new JavaIDE();
        SourceFile sourceFile = new SourceFile("Test.java",
            File.FileType.JAVA, "public class MyClass {\n\r");
        ide.update(sourceFile, "}");
    }
}