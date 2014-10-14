package master;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Network extends JPanel{

    private ArrayList<String> llistaPotencials;
    private ArrayList<String> llistaClients;

    public Network(Dimension screenSize) {
        super();
        setSize(screenSize.width/5, screenSize.height);
        setLocation(screenSize.width/20, 0);
        GroupLayout teclatLayout = new GroupLayout(this);
        setLayout(teclatLayout);
        llistaPotencials = new ArrayList<>();
        llistaClients = new ArrayList<>();
        JLabel label = new JLabel("Client List");
        label.setSize(screenSize.width/5, 25);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setLocation(0, 50);
        add(label);
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setSize(screenSize.width, 10);
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
    
    private void scan() {
        //omplir llista potencials
        //checkboxes en consequencia
    }
}
