package master;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tecla extends JButton implements ActionListener {
    public static boolean controlPressed = false;
    public static boolean shiftPressed = false;
    public static boolean alTPressed = false;
    
    public static Dimension defaultSize[];
//    public static float minFontSize = (float) 200.0;
    public static float minFontSize[];

    private int content;
    private int shiftContent;
    private int altContent;
    
    private String title;
    private String altTitle;
    private String shiftTitle;
    
    private Point position;
    private Dimension size;
    private Dimension minSize;

    private ImageIcon icona;
    
    private Teclat jefe;

    private long clickStart;

    public Tecla(String lineToParse, Dimension size, Point position, int fila,final Teclat jefe) {
        this.jefe = jefe;
        addActionListener(this);
        clickStart = -1;
        icona = null;
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jefe.send(content, true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jefe.send(content, false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        setFocusable(false);
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
        //TODO fer-ho amb arxiu de configuracio
        if (title.equalsIgnoreCase("menu")) {
            icona = new ImageIcon("images/menu.png");
        } else if (title.equalsIgnoreCase("win")) {
            icona = new ImageIcon("images/win.png");
        } else if (title.equalsIgnoreCase("shift")) {
            icona = new ImageIcon("images/shift.png");
        }else if (title.equalsIgnoreCase("left")) {
            icona = new ImageIcon("images/left.png");
        }else if (title.equalsIgnoreCase("right")) {
            icona = new ImageIcon("images/right.png");
        }else if (title.equalsIgnoreCase("up")) {
            icona = new ImageIcon("images/up.png");
        }else if (title.equalsIgnoreCase("down")) {
            icona = new ImageIcon("images/down.png");
        }else if (title.equalsIgnoreCase("Tab")) {
            icona = new ImageIcon("images/tab.png");
        }else if (title.equalsIgnoreCase("Backspace")) {
            icona = new ImageIcon("images/backspace.png");
        }else if (title.equalsIgnoreCase("Intro")) {
            icona = new ImageIcon("images/intro.png");
        }
        
        
        if (icona != null) {
            setText("");
            Image scaledInstance = icona.getImage().getScaledInstance((int) (size.width * (float) 0.8), (int) (size.height * (float) 0.8), Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledInstance));
            setIconTextGap(0);
        } else {
            setText(title);
        }
        //FI-TODO
        shiftTitle = splited[1];
        altTitle = splited[2];
        String max = (title.length() >= shiftTitle.length()) ? title : shiftTitle;
        max = (altTitle.length() > max.length()) ? altTitle : max;
        Font font = getFont();
        int length = max.length();
        Rectangle2D stringBounds = font.getStringBounds(max, getFontMetrics(font).getFontRenderContext());
        minSize = new Dimension((int) stringBounds.getWidth() + (14 * 2), (int) stringBounds.getHeight() + (6 * 2));
        float sizefont = font.getSize2D() * Math.min((float) size.width / (float) (stringBounds.getWidth() + 14 * 2), (float) size.height / (float) (stringBounds.getHeight() + 4 * 2));
        if (sizefont < Tecla.minFontSize[max.length()]) {
            Tecla.minFontSize[max.length()] = sizefont;
        }
        //de moment
        content = Integer.parseInt(splited[3]);
        shiftContent = Integer.parseInt(splited[4]);
        altContent = Integer.parseInt(splited[5]);
    }
    
    private void modifierKey() {
        if (getText().isEmpty()) {
            return;
        }
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

    public String getTitle() {
        if (Tecla.alTPressed) {
            return altTitle;
        }
        if (Tecla.shiftPressed) {
            return shiftTitle;
        }
        return title;
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

    public void setFontSize(int length) {
        setFont(getFont().deriveFont(minFontSize[length] * (float) 0.9));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
