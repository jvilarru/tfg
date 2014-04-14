package SER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tecla extends JButton {

    private char content;
    private String title;
    public static ActionListener defaultAction;
    public static Dimension defaultSize;
    private Point position;
    private Dimension size;
    private char shiftContent;
    private char altContent;
    private String altTitle;
    private String shiftTitle;
    public static boolean controlPressed = false;
    public static boolean shiftPressed = false;
    public static boolean alTPressed = false;

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
        String[] splited = lineToParse.split(",");
        this.setText(splited[0]);
        title = splited[0];
        shiftTitle = splited[1];
        altTitle = splited[2];
        content = splited[3].charAt(0);
        shiftContent = splited[4].charAt(0);
        altContent = splited[5].charAt(0);
    }

    @Override
    public void paintComponent(Graphics g) {
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
