public class SourceFileTest {
    public static void main(String args[]) {
        SourceFile sourceFile = new SourceFile("Test.java",
        FileType.JAVA,"public class MyClass {\n\r");
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
        SourceFile emptySourceFile = new SourceFile("EmptyFile.c",
        FileType.C);
        emptySourceFile.addText("//Test adding text\n\r", 3);
        System.out.println(emptySourceFile.getContent());
        SourceFile emptySourceFile2 = new SourceFile("EmptyFile2.cpp",
        FileType.C_PLUS_PLUS);
        emptySourceFile2.addText("//Test adding text\n\r");

    }
}