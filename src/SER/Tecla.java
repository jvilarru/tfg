package SER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tecla extends JButton {
    
    public static boolean controlPressed = false;
    public static boolean shiftPressed = false;
    public static boolean alTPressed = false;
    
    public static ActionListener defaultAction;
    public static Dimension defaultSize;

    private char content;
    private char shiftContent;
    private char altContent;
    
    private String title;
    private String altTitle;
    private String shiftTitle;
    
    private Point position;
    private Dimension size;

    public Tecla(String lineToParse, Dimension size, Point position, ActionListener listener) {
        if (listener == null) {
            listener = defaultAction;
        }
        this.addActionListener(listener);
        if (size == null) {
            this.size = defaultSize;
        } else {
            this.size = size;
        }
        this.setSize(this.size);
        this.position = position;
        this.setLocation(position);
        setFocusable(false);
        String[] splited = lineToParse.split(",");
        title = splited[0];
        shiftTitle = splited[1];
        altTitle = splited[2];
        content = splited[3].charAt(0);
        shiftContent = splited[4].charAt(0);
        altContent = splited[5].charAt(0);
        this.setText(title);
    }
    
    private void modifierKey(){
        if(Tecla.shiftPressed)
            setText(shiftTitle);
        else if(Tecla.alTPressed)
            setText(altTitle);
        else
            setText(title);
    }

    @Override
    protected void paintComponent(Graphics g) {
        modifierKey();
        super.paintComponent(g);
    }

    public String getContent() {
        if (Tecla.alTPressed) {
            return "" + altContent;
        }
        if (Tecla.shiftPressed) {
            return "" + shiftContent;
        }
        return "" + content;
    }
}
