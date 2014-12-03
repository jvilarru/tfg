package master;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Master extends JFrame {
    private final String defaultLayout = "layoutES.ser";

    private Network xarxa;
    private static String IP;

    private ArrayList<Emiter> llista;
    private String name = "Server";

    private JTabbedPane tabs;

    private Teclat teclat;
    private Trackpad trackpad;
    private TauletaGrafica tgrafica;
    
    private JPanel pOpcions;
    private JButton exitButton;
    private boolean transAvaiable;

    public Master() throws IOException {
        super("SER");
        GraphicsDevice gd = getGraphicsConfiguration().getDevice();
        transAvaiable = true;
        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)){
            System.err.println("Translucencia no suportada");
            transAvaiable = false;
        }
        
        setUndecorated(true);
        setResizable(false);
        setPreferredSize(getGraphicsConfiguration().getBounds().getSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        boolean success = (getExtendedState() == JFrame.MAXIMIZED_BOTH);
        if (!success) {
            System.err.println("Could not maximize the window");
        }
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
        pack();
        
        Dimension screenSize = getSize();
        screenSize.height-=42;

        //INIT TABS
        tabs.setFocusable(false);
        float f = 25;
        tabs.setFont(tabs.getFont().deriveFont(f));

        teclat = new Teclat(defaultLayout, screenSize,this);
        trackpad = new Trackpad(screenSize);
        tgrafica = new TauletaGrafica(screenSize,this);
        

        tabs.add(teclat);
        tabs.add(trackpad);
        tabs.setEnabledAt(1, false);
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
        exitButton.setLocation(screenSize.width - screenSize.width/10 - 50,screenSize.height - screenSize.height/10 -50);
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exitSER(null);
            }
        });

        //xarxa
        xarxa = new Network(screenSize);
        pOpcions.add(xarxa);
        final JFrame Masterframe = this;
        //slider transparencia
        JLabel lab = new JLabel("Transparència");
        lab.setSize(screenSize.width/5, 25);
        lab.setFont(lab.getFont().deriveFont(f));
        lab.setLocation(screenSize.width - screenSize.width/5, 50);
        lab.setEnabled(transAvaiable);
        pOpcions.add(lab);
        
        JSlider slid = new JSlider(0, 100);
        slid.setSize(screenSize.width/5, screenSize.width/20);
        slid.setLocation(screenSize.width - screenSize.width/5 - 50, 75);
        slid.setEnabled(transAvaiable);
        slid.setValue(0);
        slid.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Masterframe.setOpacity(((JSlider)e.getSource()).getValue()/100f);
            }
        });
        pOpcions.add(slid);
        
        pOpcions.setName("Opcions");
        
        //Fi opcions
        tabs.add(pOpcions);
        JPanel close = new JPanel();
        close.setName("X");
        tabs.add(close);
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
              JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
              int index = sourceTabbedPane.getSelectedIndex();
              if(index==4){
                  System.exit(1);
              }
            }
        };
        tabs.addChangeListener(changeListener);
        tabs.setEnabledAt(3, false);

//        tabs.setSelectedIndex(3);//temporal per a veure millor la pantalla opcions
        xarxa.demo(IP);
        pack();

    }

    public static void main(String args[]) throws SocketException, IOException {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) and display of the window">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        IP = args[0];
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

    public void send(int ID, boolean pressed, int keycode) {
        if(ID==0){//TECLAT
            xarxa.sendKeyboardDemo(ID, pressed, keycode);
        }
        if(ID==1){//Tauleta
            xarxa.sendbuttonsDemo(ID, pressed, keycode);
        }
    }
    
    public void send(int ID, float x, float y) {
        xarxa.sendPositionDemo(ID, x, y);
    }
}
