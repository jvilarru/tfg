package SER;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

public class Tecla extends JButton implements ActionListener {
    public static boolean controlPressed = false;
    public static boolean shiftPressed = false;
    public static boolean alTPressed = false;
    
    public static Dimension defaultSize[];

    private char content;
    private char shiftContent;
    private char altContent;
    
    private String title;
    private String altTitle;
    private String shiftTitle;
    
    private Point position;
    private Dimension size;
    private Dimension minSize;

    public Tecla(String lineToParse, Dimension size, Point position) {
        addActionListener(this);
        setFocusable(false);
        //TODO font proporcional
        this.size = size;
        this.position = position;
        setSize(size);
        this.setLocation(position);
        String[] splited;
        if (lineToParse.startsWith("\\")) {
            splited = lineToParse.substring(1).split("<");
        } else {
            splited = lineToParse.split(",");
        }
        title = splited[0];
        shiftTitle = splited[1];
        altTitle = splited[2];
        String max = (title.length() >= shiftTitle.length()) ? title : shiftTitle;
        max = (altTitle.length() > max.length()) ? altTitle : max;
        Font font = getFont();
        Rectangle2D stringBounds = font.getStringBounds(max, getFontMetrics(font).getFontRenderContext());
        minSize = new Dimension((int) stringBounds.getWidth() + (14 * 2), (int) stringBounds.getHeight() + (6 * 2));

        //de moment
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO fer algo mes
        System.out.println(content);
    }
}
