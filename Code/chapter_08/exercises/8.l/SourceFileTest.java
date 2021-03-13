public class SourceFileTest {
    public static void main(String args[]) {
        SourceFile sourceFile = new SourceFile("Test.java",
            FileType.JAVA, "public class MyClass {\n\r");
        System.out.println(sourceFile.getContent());
        // Test addText (String) correct
        sourceFile.addText("}");
        System.out.println(sourceFile.getContent());
        // Test addText (String,int) correct
        sourceFile.addText("//Test adding text\n\r", 23);
        System.out.println(sourceFile.getContent());
        // Test addText (String,int) incorrect
        sourceFile.addText("//Test adding text\n\r", -1);
        System.out.println(sourceFile.getContent());
        // Test addText (String,int) incorrect
        sourceFile.addText("//Test adding text\n\r", 100);
        System.out.println(sourceFile.getContent());
    }
}