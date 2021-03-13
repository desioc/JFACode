public class SourceFile extends File {
    private String content;

    public SourceFile(String name, int type) {
        super(name, type);
    }

    public SourceFile(String name, int type, String content) {
        this(name, type);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addText(String text) {
        if (content == null) {
            content ="";
        }
        if (text != null) {
            content += text;
        }
    }
    
    public void addText(String text, int position) {
        final int length = content.length();
        if (content != null && text != null && position > 0
        && position < length) {
            content = content.substring(0, position) + text +
            content.substring(position);
        }
    }
}