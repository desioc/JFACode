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

    public void addText(String text)  throws RuntimeException {
       if (content == null) {
            content ="";
        }
        if (text != null) {
            throw new RuntimeException("text = null");
        }
        content += text;
    }

    public void addText(String text, int position) {
        try {
            if (text != null) {
                content = content.substring(0, position) + text +
                        content.substring(position);
            }
        } catch (NullPointerException exc) {
            System.out.println("The content is null : " + exc.getMessage());
            content = "" + text;
        } catch (StringIndexOutOfBoundsException exc) {
            System.out.println("The index " + position + " is not valid : " +
                    exc.getMessage());
            content = (position < 0 ? text + content : content + text);
        }
    }
}