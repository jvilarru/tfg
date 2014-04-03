package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tecla extends JButton{
    
    private final char content;
    public static ActionListener defaultAction;
    public static Dimension defaultSize;


    public Tecla(String text, Dimension size, Point position, char content,ActionListener listener) {
        this.content = content;
        if(listener == null) listener = defaultAction;
        this.addActionListener(listener);
        this.setText(text);
        if(size == null) size=defaultSize;
        this.setSize(size);
        this.setLocation(position);
    }

    public char getContent() {
        return content;
    }
}
