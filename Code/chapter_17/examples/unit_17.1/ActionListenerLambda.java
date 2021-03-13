import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionListenerLambda {
    public static void main(String args[]) {
        JButton button1 = new JButton("Anonymous Class");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Before Java 8: Anonymous Class");
            }
        } );
        JButton button2 = new JButton("Lambda expression");
        button2.addActionListener(e->System.out.println("Java 8: Anonymous function"));
        JFrame frame = new JFrame ("Test ActionListenerLambda");
        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}