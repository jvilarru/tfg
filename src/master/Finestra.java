package master;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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

    private class rawData {

        public String datos;
        public double relWidth, relHeight;
        public Tecla tecla;
    }

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
//FI 
        setPreferredSize(screenSize);
        initComponents();

//        setSize(screenSize);
        screenSize = getSize();
        screenSize.height -= 35;
        model = new DefaultListModel<>();
        jList1.setModel(model);
        jSlider1.setMaximum(100);
        
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
        tauletaGrafica = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName("tabs"); // NOI18N

        tauletaGrafica.setOpaque(false);

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tauletaGraficaLayout = new javax.swing.GroupLayout(tauletaGrafica);
        tauletaGrafica.setLayout(tauletaGraficaLayout);
        tauletaGraficaLayout.setHorizontalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tauletaGraficaLayout.createSequentialGroup()
                .addGroup(tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tauletaGraficaLayout.setVerticalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tauletaGraficaLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tauleta gràfica", tauletaGrafica);

        jPanel1.setOpaque(false);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setValue(100);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Opacity");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Client List");

        jButton2.setText("Scan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(375, 375, 375)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opcions", jPanel1);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //TODO ferho al principi i aqui nomes comprovar una variable
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
            jSlider1.setEnabled(false);
            jLabel1.setEnabled(false);
            System.err.println("Transparencia no suportada per el sistema operatiu");
        } else {
            setOpacity((float) (jSlider1.getValue() / 100.0));
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        float auxX = (float) evt.getX() / (float) (((JPanel) evt.getSource()).getWidth());
        float auxY = (float) evt.getY() / (float) (((JPanel) evt.getSource()).getHeight());
        tauletaGrafica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        System.out.print("PRESSED");
        System.out.print("\tx-> " + auxX);
        System.out.print("\ty-> " + auxY);
        System.out.println("\tbutton-> " + evt.getButton());
        tauleta_clicked = true;
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        tauleta_clicked = false;
        tauletaGrafica.setCursor(Cursor.getDefaultCursor());
        System.out.print("RELEASED");
        System.out.println("\tbutton-> " + evt.getButton());
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        float auxX = (float) evt.getX() / (float) (((JPanel) evt.getSource()).getWidth());
        float auxY = (float) evt.getY() / (float) (((JPanel) evt.getSource()).getHeight());
        System.out.print("MOVED");
        System.out.print("\t x-> " + auxX);
        System.out.println("\t y-> " + auxY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Enumeration<NetworkInterface> networkInterfaces;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    boolean found = false;
                    NetworkInterface iface = networkInterfaces.nextElement();
                    if (iface.isUp() && !iface.isLoopback()) {
                        ArrayList<InterfaceAddress> inetAddresses = (ArrayList<InterfaceAddress>) iface.getInterfaceAddresses();
                        if (!inetAddresses.isEmpty()) {
                            for (int i = 0; i < inetAddresses.size() && !found; i++) {
                                InetAddress bcst = inetAddresses.get(i).getBroadcast();
                                if (bcst != null) {
                                    found = true;
                                    scanPack.setAddress(bcst);
                                    scanPack.setData(name.getBytes());
                                    scanPack.setLength(name.getBytes().length);
                                    scanPack.setPort(client.Client.port);
                                    scanSock.setBroadcast(true);
                                    scanSock.send(scanPack);
                                    scanSock.setSoTimeout(1000);
                                    boolean timeout = false;
                                    while (!timeout) {
                                        try {
                                            scanSock.receive(scanPack);
                                            String client_name = new String(scanPack.getData(), 0, scanPack.getLength());
                                            if (!model.contains(client_name)) {
                                                model.addElement(client_name);
                                                Emiter e = new Emiter(scanPack.getSocketAddress(), client_name);
                                                llista.add(e);
                                            }
                                        } catch (SocketTimeoutException ex) {
                                            timeout = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                    new Finestra().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tauletaGrafica;
    // End of variables declaration//GEN-END:variables
}
