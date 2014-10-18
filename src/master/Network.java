package master;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Network extends JPanel{

    private ArrayList<String> llistaPotencials;
    private ArrayList<String> llistaClients;
    private int width;

    public Network(Dimension screenSize) {
        super();
        width = screenSize.width / 5;
        setSize(width, screenSize.height);
        setLocation(screenSize.width/20, 0);
        GroupLayout teclatLayout = new GroupLayout(this);
        setLayout(teclatLayout);
        llistaPotencials = new ArrayList<>();
        llistaClients = new ArrayList<>();
        JLabel label = new JLabel("Client List");
        label.setSize(width, 25);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setLocation(0, 50);
        add(label);
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setSize(width, 10);
        sep.setLocation(0, 80);
        add(sep);
        JButton boto = new JButton("Scan");
        boto.setSize(screenSize.width/10, 50);
        boto.setLocation(0, screenSize.height - 100);
        boto.setFont(boto.getFont().deriveFont(25f));
        boto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                scan();
            }
        });
        add(boto);
    }

    public void test() {
        llistaPotencials.add("Pedrito");
        llistaPotencials.add("Pablito");
        llistaPotencials.add("Paquito");
        llistaClients.add("Pablito");
        populate();
    }
    
    private void scan() {
        test();
        //omplir llista potencials
        //checkboxes en consequencia
    }

    private void populate() {
        int height = 100;
        for (String poten : llistaPotencials) {
            JCheckBox cb = new JCheckBox(poten, llistaClients.contains(poten));
            cb.setLocation(0, height);
            height += 25;
            cb.setFont(cb.getFont().deriveFont(25f));
            cb.setSize(width, 25);
            cb.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox cb = ((JCheckBox) e.getSource());
                    if (cb.isSelected()) {
                        llistaClients.add(cb.getName());
                    }
                }
            });
            add(cb);
        }
    }
}
