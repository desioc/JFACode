import java.applet.*;
import java.awt.*;

public class ParameterApplet extends Applet {
    String s;
    @Override 
    public void init() {
        String parameterName = "p";
        s = getParameter(parameterName);
    }
    @Override
    public void paint(Graphics g) {
        g.drawString(s, 10, 10);
    }
}
