package master;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Master extends JFrame {
    private final String defaultLayout = "layoutES.ser";
    private boolean tauleta_clicked = false;
    private DefaultListModel<String> model;
    private ArrayList<Emiter> llista;
    private String name = "Server";

    private DatagramSocket scanSock;
    private DatagramPacket scanPack;
    private byte[] scanBuff;

    private JTabbedPane tabs;

    private Teclat teclat;
    private Trackpad trackpad;

    public Master() throws IOException {
        super("SER");
//        ArrayList<Double> tamanys = new ArrayList<>();
//        llista = new ArrayList();
//        scanSock = new DatagramSocket();
//        scanBuff = new byte[client.Client.BUFF_LEN];
//        scanPack = new DatagramPacket(scanBuff, client.Client.BUFF_LEN);
//        model = new DefaultListModel<>();
//        jList1.setModel(model);
//        jSlider1.setMaximum(100);

        GraphicsDevice gd = getGraphicsConfiguration().getDevice();
        setUndecorated(true);
//        setResizable(false);
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setPreferredSize(getGraphicsConfiguration().getBounds().getSize());
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            boolean success = (getExtendedState() == JFrame.MAXIMIZED_BOTH);
            if (!success) {
                setExtendedState(Frame.MAXIMIZED_BOTH);
            }
        }
        setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//        Frame frame = new Frame(null)
//        Dimension screenSize = new Dimension();
//        setLocation(new Point(0, 0));
//        screenSize.height = gd.getDisplayMode().getHeight();
//        screenSize.width = gd.getDisplayMode().getWidth();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setUndecorated(true);
//        setResizable(false);
//        setVisible(true);
        tabs = new JTabbedPane();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
//        setSize(screenSize);
        setName("SER");
        pack();
        Dimension screenSize = getSize();

        //INIT TABS
        tabs.setFocusable(false);

        teclat = new Teclat(defaultLayout, screenSize);
        trackpad = new Trackpad(screenSize);

        tabs.add(teclat, 0);
        tabs.add(trackpad, 1);
        tabs.setSelectedIndex(0);

        teclat.setFocusable(true);
        teclat.requestFocusInWindow();
        teclat.setFocusTraversalKeysEnabled(false);

    }

    public static void main(String args[]) throws SocketException, IOException {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) and display of the window">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Master w = new Master();
                    w.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

}
