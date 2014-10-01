package master;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TauletaGrafica extends JPanel{
    private JButton left, center, right;
    private JPanel panel;
    
    public TauletaGrafica(Dimension dim) {
        super();
        setSize(dim);
        setPreferredSize(dim);
        setName("Tauleta gràfica");

        GroupLayout l = new GroupLayout(this);
        setLayout(l);

        left = new JButton();
        left.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.4));
        left.setLocation(0, 0);
        add(left);

        center = new JButton();
        center.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.2));
        center.setLocation(0, (int) (dim.height * 0.4));
        add(center);

        right = new JButton();
        right.setSize((int) (dim.width * 0.08), (int) (dim.height * 0.4));
        right.setLocation(0, (int) (dim.height * 0.6));
        add(right);

        panel = new JPanel();
        panel.setSize((int) (dim.width* 0.92), dim.height );
        panel.setLocation((int) (dim.width *0.08), 0);
        add(panel);
    }
    
}
