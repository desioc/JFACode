public class SourceFileTest {
    public static void main(String args[]) {
        SourceFile sourceFile = new SourceFile("Test.java",
            FileType.JAVA, "public class MyClass {\n\r");
        System.out.println(sourceFile.getContent());
        // Correct test addText (String)     
        sourceFile.addText("}");
        System.out.println(sourceFile.getContent());
        // Correct test addText (String,int) 
        sourceFile.addText("//Test text addition\n\r", 23);
        System.out.println(sourceFile.getContent());
        // Incorrect test addText (String,int) 
        sourceFile.addText("//Test text addition\n\r", -1);
        System.out.println(sourceFile.getContent());
        // Incorrect test addText (String,int) 
        sourceFile.addText("//Test text addition\n\r", 100);
        System.out.println(sourceFile.getContent());
    }
}