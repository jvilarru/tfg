package master;

import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
    private TauletaGrafica tgrafica;
    
    private JPanel pOpcions;
    private JButton exitButton;
    private List<JCheckBox> llistaClients;

    public Master() throws IOException {
        super("SER");
        GraphicsDevice gd = getGraphicsConfiguration().getDevice();
        setUndecorated(true);
        setResizable(false);
//        if (gd.isFullScreenSupported()) {
//            System.err.println("fullscreen");
//            gd.setFullScreenWindow(this);            
//        } else {
//            System.err.println("NO fullscreen");
            setPreferredSize(getGraphicsConfiguration().getBounds().getSize());
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            boolean success = (getExtendedState() == JFrame.MAXIMIZED_BOTH);
            if (!success) {
                System.err.println("Could not maximize the window");
            }
//        }
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        setName("SER");
        
        
        Dimension screenSize = getSize();
        screenSize.height-=42;

        //INIT TABS
        tabs.setFocusable(false);
        float f = 25;
        tabs.setFont(tabs.getFont().deriveFont(f));

        teclat = new Teclat(defaultLayout, screenSize);
        trackpad = new Trackpad(screenSize);
        tgrafica = new TauletaGrafica(screenSize);
        

        tabs.add(teclat);
        tabs.add(trackpad);
        tabs.add(tgrafica);
        
        tabs.setSelectedIndex(0);

        teclat.setFocusable(true);
        teclat.requestFocusInWindow();
        teclat.setFocusTraversalKeysEnabled(false);
        
        //Pantalla opcions
        pOpcions = new JPanel();
        GroupLayout opcionsLayout = new GroupLayout(pOpcions);
        pOpcions.setLayout(opcionsLayout);
        
        //BOTO exit
        exitButton = new JButton("Exit");
        exitButton.setFont(exitButton.getFont().deriveFont(f));
        exitButton.setSize(screenSize.width/10,screenSize.height/10 );
        pOpcions.add(exitButton);
        exitButton.setLocation(screenSize.width - screenSize.width/10,0);
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exitSER(null);
            }
        });
        
        //Llista clients
        
        model = new DefaultListModel<>();
        model.addElement("alfa");
        model.addElement("beta");
        llistaClients = new ArrayList<>();
        llistaClients.add(new JCheckBox("alfa", false));
        llistaClients.add(new JCheckBox("beta", true));
        llistaClients.add(new JCheckBox("omega", false));
        int ypos=30;
        for (JCheckBox box : llistaClients) {
            box.setSize(screenSize.width/5,30);
            box.setFont(box.getFont().deriveFont(f));
            box.setLocation(0, ypos);
            ypos+=30;
            
            pOpcions.add(box);
        }
        
        JLabel titol= new JLabel("Client list");
        titol.setFont(titol.getFont().deriveFont(f));
        titol.setSize(screenSize.width/5,25);
        titol.setLocation(0, 0);
        pOpcions.add(titol);
        pOpcions.setName("Opcions");
        
        //Fi opcions
        tabs.add(pOpcions);
        tabs.setSelectedIndex(3);//temporal per a veure millor la pantalla opcions
        
        pack();

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
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Master w = new Master();
                    w.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    
    private void exitSER(String Error){
        if(Error != null && !Error.equalsIgnoreCase("Normal Exit")){
            System.err.print("Exiting with error: ");
            System.err.println(Error);
            System.exit(1);
        }
        else{
            System.exit(0);
        }
        
    }

}
