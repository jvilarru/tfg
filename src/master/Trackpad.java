package master;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Trackpad extends JPanel {

    private JButton left, center, right;
    private JPanel panel;

    public Trackpad(Dimension dim) {
        super();
        setSize(dim);
        setName("Trackpad");

        GroupLayout l = new GroupLayout(this);
        setLayout(l);

        left = new JButton();
        left.setSize((int) (dim.width * 0.4), (int) (dim.height * 0.1));
        left.setLocation(0, (int) (dim.height * 0.9));
        add(left);

        center = new JButton();
        center.setSize((int) (dim.width * 0.2), (int) (dim.height * 0.1));
        center.setLocation((int) (dim.width * 0.4), (int) (dim.height * 0.9));
        add(center);

        right = new JButton();
        right.setSize((int) (dim.width * 0.4), (int) (dim.height * 0.1));
        right.setLocation((int) (dim.width * 0.6), (int) (dim.height * 0.9));
        add(right);

        panel = new JPanel();
        panel.setSize(dim.width, (int) (dim.height * 0.9));
        panel.setLocation(0, 0);
        add(panel);

    }
}
