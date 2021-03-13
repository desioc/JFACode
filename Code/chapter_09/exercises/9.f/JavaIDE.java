public class JavaIDE implements IDE {
    @Override
    public void update(SourceFile file, String text) {
        IDE.super.update(file, text);
        file.addText(text);
        System.out.println("Content updated:\n"+ file.getContent());
    }
}