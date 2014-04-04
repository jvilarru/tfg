package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tecla extends JButton{
    
    private char content;
    public static ActionListener defaultAction;
    public static Dimension defaultSize;
    
    private char altContent;

    public char getAltContent() {
        return altContent;
    }

    public void setAltContent(char altContent) {
        this.altContent = altContent;
    }

    
    private char shiftContent;

    public char getShiftContent() {
        return shiftContent;
    }

    public void setShiftContent(char content) {
        this.shiftContent = content;
    }
    
    private String altTitle;

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }


    private String shiftTitle;

    public String getShiftTitle() {
        return shiftTitle;
    }

    public void setShiftTitle(String shiftTitle) {
        this.shiftTitle = shiftTitle;
    }


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
