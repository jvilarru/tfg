package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tecla extends JButton{
    
    private final char content;

    public Tecla(String text, Dimension size, Point position, char content,ActionListener listener) {
        this.content = content;
        this.addActionListener(listener);
        this.setText(text);
        this.setSize(size);
        this.setLocation(position);
    }

    public char getContent() {
        return content;
    }
}
