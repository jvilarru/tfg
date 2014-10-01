package master;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Finestra extends javax.swing.JFrame {

    private final String defaultLayout = "layoutES.ser";
    private boolean tauleta_clicked = false;
    private DefaultListModel<String> model;
    private ArrayList<Emiter> llista;
    private String name = "Server";

    private DatagramSocket scanSock;
    private DatagramPacket scanPack;
    private byte[] scanBuff;
    private Teclat teclat;
    private Trackpad trackpad;


//    private ArrayList<ArrayList<rawData>> matriu = new ArrayList<>();
//    private ArrayList<Double> tamanys = new ArrayList<>();

    public Finestra() throws SocketException, IOException {
//        ArrayList<Double> tamanys = new ArrayList<>();
        llista = new ArrayList();
        scanSock = new DatagramSocket();
        scanBuff = new byte[client.Client.BUFF_LEN];
        scanPack = new DatagramPacket(scanBuff, client.Client.BUFF_LEN);
//NO FUNCIONA BE
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Dimension screenSize = new Dimension();
        screenSize.height = gd.getDisplayMode().getHeight();
        screenSize.width = gd.getDisplayMode().getWidth();
//        
////FI 
        setPreferredSize(screenSize);
        
        
        initComponents();
        addStuff();

        
        

//        setSize(screenSize);
        

        model = new DefaultListModel<>();

        
        
    }
    
    public void addStuff() throws IOException{
        Dimension screenSize = getPreferredSize();
        System.out.println("width-->" + screenSize.width + " height--> " + screenSize.height);
        teclat = new Teclat(defaultLayout, screenSize);
        trackpad = new Trackpad(screenSize);

        
        jTabbedPane1.add(teclat, 0);
        jTabbedPane1.add(trackpad, 1);
        jTabbedPane1.setSelectedIndex(0);
        
        
        teclat.setFocusable(true);
        teclat.requestFocusInWindow();
        teclat.setFocusTraversalKeysEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("finestra"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName("tabs"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Tabs");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//        DatagramSocket socket = new DatagramSocket();
//        byte buf[] = new byte[client.Client.BUFF_LEN];
//        boolean found = false;
//        String server_name = "Halfonso";
//        DatagramPacket paquet = new DatagramPacket(buf, client.Client.BUFF_LEN);
//        Enumeration<NetworkInterface> networkInterfaces;
//        networkInterfaces = NetworkInterface.getNetworkInterfaces();
//        if (networkInterfaces != null) {
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface iface = networkInterfaces.nextElement();
//                if (iface.isUp() && !iface.isLoopback()) {
//                    List<InterfaceAddress> inetAddresses = iface.getInterfaceAddresses();
//                    if (!inetAddresses.isEmpty()){
//                        for (int i = 0; i < inetAddresses.size() && !found;i++) {
//                            InterfaceAddress iaddress = inetAddresses.get(i);
//                            InetAddress bcst = iaddress.getBroadcast();
//                            if(bcst != null){
//                                found = true;
//                                paquet.setAddress(bcst);
//                                paquet.setData(server_name.getBytes());
//                                paquet.setLength(server_name.getBytes().length);
//                                paquet.setPort(client.Client.port);
//                                socket.setBroadcast(true);
//                                socket.send(paquet);
//                                //PROVA
//                                DatagramPacket pack = new DatagramPacket(buf, 1024);
//                                socket.receive(pack);
//                                
//                                //FI-PROVA
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        InetAddress localHost = InetAddress.getLoopbackAddress();
//        System.out.println(localHost.getHostAddress());
//        paquet.setAddress(localHost);
//        paquet.setData(server_name.getBytes());
//        paquet.setLength(server_name.getBytes().length);
//        paquet.setPort(client.Client.port);
//        socket.setBroadcast(true);
//        socket.send(paquet);
//        socket.receive(paquet);
//        System.out.println(new String(paquet.getData(),0,paquet.getLength()));
//        Socket s = new Socket();
//        s.connect(paquet.getSocketAddress());
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintStream out = new PrintStream(s.getOutputStream());
//        String line = in.readLine();
//        while (!line.equalsIgnoreCase("STOP")){
//            out.println(line);
//            out.flush();
//            line = in.readLine();
//        }
//        out.println(line);
//        s.close();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Finestra f  = new Finestra();
                    f.setVisible(true);
                    Dimension dim = f.getContentPane().getSize();
                    System.out.println("width-->" + dim.width + " height--> " + dim.height);
//                    f.addStuff();
                    
 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
