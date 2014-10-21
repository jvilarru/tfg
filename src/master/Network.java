package master;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Network extends JPanel{

    private ArrayList<Emiter> llistaClients;
    private final int width;

    public Network(Dimension screenSize) {
        super();
        width = screenSize.width / 5;
        setSize(width, screenSize.height);
        setLocation(screenSize.width/20, 0);
        GroupLayout teclatLayout = new GroupLayout(this);
        setLayout(teclatLayout);
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

    public void test() throws IOException {
        
        int port = 42;
        String locName = "Halfonso";
        InetAddress add = Inet4Address.getByName("192.168.0.1");
        InetSocketAddress inetSocketAddress = new InetSocketAddress(add, port);
        Emiter e = new Emiter(inetSocketAddress, locName);
        llistaClients.add(e);
        Emiter e2 = new Emiter(inetSocketAddress, "Halfonso2");
        llistaClients.add(e2);
        Emiter e3 = new Emiter(inetSocketAddress, "Halfonso3");
        llistaClients.add(e3);
        e3.connect();
    }
    
    private void scan() {
        try {
            test();
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //omplir llista Emiters
        populate();
        repaint();
    }

    private void populate() {
        int height = 100;
        for (Emiter em : llistaClients) {
            JCheckBox cb = new JCheckBox(em.getName(), em.isConnected());
            cb.setLocation(0, height);
            height += 25;
            cb.setFont(cb.getFont().deriveFont(25f));
            cb.setSize(width, 25);
            cb.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox cb = ((JCheckBox) e.getSource());
                    if (cb.isSelected()) {
                        for(Emiter em : llistaClients){
                            if(em.amI(cb.getName())){
                                em.connect();
                            }
                        }
                    }
                }
            });
            add(cb);
        }
    }
}
