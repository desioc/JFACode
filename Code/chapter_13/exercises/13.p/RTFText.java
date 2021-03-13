public class RTFText implements Cloneable {
    String text;
    Font character;
    boolean underlined;
    
    public RTFText (String text, Font character, boolean underlined){
        this.text = text;
        this.character = character;
        this.underlined = underlined;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public String toString(){
        return "Text = " + text + ", character = " + character + ",  underlined = " + underlined;
    }
    
    
}