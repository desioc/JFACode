import java.awt.*;

public class FrameWithButton {
    public static void main(String args[]) {
        Frame frame = new Frame("Title");
        Button button = new Button("Click me");
        frame.add(button);
        frame.setSize(200,100);
        frame.setVisible(true);
    }
}