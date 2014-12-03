package master;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private Emiter demo;
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

    public void demo(String IP) throws IOException {
        
//        int port = 42;
//        String locName = "Halfonso";
//        InetAddress add = Inet4Address.getByName("192.168.0.1");
//        InetSocketAddress inetSocketAddress = new InetSocketAddress(add, port);
//        Emiter e = new Emiter(inetSocketAddress, locName);
//        llistaClients.add(e);
//        Emiter e2 = new Emiter(inetSocketAddress, "Halfonso2");
//        llistaClients.add(e2);
//        Emiter e3 = new Emiter(inetSocketAddress, "Halfonso3");
//        llistaClients.add(e3);
//        e3.connect();
        int port = 8888;
        String locName = "Halfonso";
        InetAddress add = Inet4Address.getByName(IP);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(add, port);
        demo = new Emiter(inetSocketAddress, locName);
//        demo.demo();
    }
    
    public void sendKeyboardDemo(int ID, boolean pressed, int keycode){
        String send = ID + ":" + pressed + ":" + keycode;
        demo.demoWrite(send);
    }
    
    public void sendPositionDemo(int ID,float x,float y){
        String send = ID + ":0:0" + x + ":" + y;
        demo.demoWrite(send);
    }
    
    public void sendbuttonsDemo(int ID, boolean pressed, int boto){
        String send = ID + ":1:" + pressed + ":" + boto;
        demo.demoWrite(send);
    }
    
    public InetAddress getNetworkLocalBroadcastAddressdAsInetAddress() throws IOException {
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
            NetworkInterface intf = en.nextElement();
            InetAddress addr = intf.getInetAddresses().nextElement();
            if(!addr.isLoopbackAddress()){              
                byte[] quads = addr.getAddress();
                quads[0] = (byte)255;
                quads[1] = (byte)255;
                return InetAddress.getByAddress(quads);
            }
        }
        return null;
    }
    
    private void scan() {
//        try {
////            test();
//        } catch (IOException ex) {
//            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DatagramSocket sock;
//        IPAdress.Broadcast;
//        SocketAddress saddr = new InetSocketAddress(new Inet4Address, WIDTH)
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
