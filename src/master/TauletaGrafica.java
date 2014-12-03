package master;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TauletaGrafica extends JPanel{
    private JButton left, center, right;
    private JPanel panel;
    private Master boss;
    
    public TauletaGrafica(Dimension dim,final Master boss) {
        super();
        this.boss=boss;
        setSize(dim);
        setPreferredSize(dim);
        setName("Tauleta gràfica");

        GroupLayout l = new GroupLayout(this);
        setLayout(l);

        left = new JButton();
        left.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.4));
        left.setLocation(0, 0);
        add(left);
        left.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boss.send(1, true, InputEvent.BUTTON1_DOWN_MASK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boss.send(1, false, InputEvent.BUTTON1_DOWN_MASK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });

        center = new JButton();
        center.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.2));
        center.setLocation(0, (int) (dim.height * 0.4));
        add(center);
        center.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boss.send(1, true, InputEvent.BUTTON3_DOWN_MASK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boss.send(1, false, InputEvent.BUTTON3_DOWN_MASK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });

        right = new JButton();
        right.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.4));
        right.setLocation(0, (int) (dim.height * 0.6));
        add(right);
        right.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boss.send(1, true, InputEvent.BUTTON2_DOWN_MASK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boss.send(1, false, InputEvent.BUTTON2_DOWN_MASK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });

        panel = new JPanel();
        panel.setSize((int) (dim.width* 0.92), dim.height );
        panel.setLocation((int) (dim.width *0.08), 0);
        add(panel);
        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point point = e.getPoint();
                boss.send(1, ((float)point.x/(float)panel.getWidth()), ((float)point.y/(float)panel.getHeight()));
            }
        });
    }
    
}
