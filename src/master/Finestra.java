package master;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private ArrayList<ArrayList<rawData>> matriu = new ArrayList<>();
    private boolean tauleta_clicked = false;
    private DefaultListModel<String> model;
    private ArrayList<Emiter> llista;
    private String name = "Server";
    
    private DatagramSocket scanSock;
    private DatagramPacket scanPack;
    private byte[] scanBuff;

    private class rawData {
        public String datos;
        public double relWidth, relHeight;
        public Tecla tecla;
    }

    public Finestra() throws FileNotFoundException, IOException {
        ArrayList<Double> tamanys = new ArrayList<>();
        llista = new ArrayList();
        scanSock = new DatagramSocket();
        scanBuff = new byte[client.Client.BUFF_LEN];
        scanPack = new DatagramPacket(scanBuff, client.Client.BUFF_LEN);
        initComponents();
        model = new DefaultListModel<>();
        jList1.setModel(model);
        jSlider1.setMaximum(100);
        BufferedReader br = new BufferedReader(new FileReader(defaultLayout));
        ArrayList<rawData> linia;
        rawData raw;
        int i = 0;
        String line = br.readLine();
        while (line != null) {
            linia = new ArrayList<>();
            tamanys.add(0.0);
            while (line != null && !line.equals("NEWLINE")) {
                raw = new rawData();
                String[] split;
                String[] size;
                if (line.startsWith("\\")) {
                    split = line.split(">");
                    size = split[1].split("<");
                } else {
                    split = line.split(";");
                    size = split[1].split(",");
                }
                raw.datos = split[0];
                raw.relWidth = Double.parseDouble(size[0]);
                raw.relHeight = Double.parseDouble(size[1]);
                Double get = tamanys.get(i) + Double.parseDouble(size[0]);
                tamanys.set(i, get);
                linia.add(raw);
                line = br.readLine();
            }
            matriu.add(linia);
            i++;
            line = br.readLine();
        }
        br.close();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Dimension screenSize = new Dimension();
        screenSize.height = gd.getDisplayMode().getHeight();
        screenSize.width = gd.getDisplayMode().getWidth();
        setSize(screenSize);
        teclat.setSize(screenSize.width, screenSize.height - 27);
        screenSize = teclat.getSize();
        int num_files = matriu.size();
        Tecla.minFontSize = new float[20];
        for (i = 0; i < 20; i++) {
            Tecla.minFontSize[i] = (float) 200.0;
        }
        for (i = 0; i < num_files; i++) {
            linia = matriu.get(i);
            Double width_size = tamanys.get(i);
            double accum = 0.0;
            for (rawData linia1 : linia) {
                if (!linia1.datos.equals("EMPTY")) {
                    Dimension dim = new Dimension((int) ((screenSize.width / width_size) * linia1.relWidth), (int) ((screenSize.height / num_files) * linia1.relHeight));
                    Point p = new Point((int) (accum * (screenSize.width / width_size)), i * (screenSize.height / num_files));
                    linia1.tecla = new Tecla(linia1.datos, dim, p, i);
                    teclat.add(linia1.tecla);
                }
                accum += linia1.relWidth;
            }
        }
        for (i = 0; i < num_files; i++) {
            for (rawData linia1 : matriu.get(i)) {
                Tecla t = linia1.tecla;
                if (t != null) {
                    t.setFontSize(t.getTitle().length());
                }

            }
        }
        teclat.setFocusable(true);
        teclat.requestFocusInWindow();
        teclat.setFocusTraversalKeysEnabled(false);
        left_button.setSize((int) (screenSize.width * 0.4), left_button.getSize().height);
        middle_button.setSize((int) (screenSize.width * 0.2), middle_button.getSize().height);
        right_button.setSize((int) (screenSize.width * 0.4), right_button.getSize().height);
        jTabbedPane1.add(new JPanel(), 0);
        jTabbedPane1.getComponentAt(0).setName("test");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        teclat = new javax.swing.JPanel();
        trackpad = new javax.swing.JPanel();
        left_button = new javax.swing.JButton();
        right_button = new javax.swing.JButton();
        middle_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
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

        teclat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teclat.setName("teclat"); // NOI18N
        teclat.setOpaque(false);

        javax.swing.GroupLayout teclatLayout = new javax.swing.GroupLayout(teclat);
        teclat.setLayout(teclatLayout);
        teclatLayout.setHorizontalGroup(
            teclatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        teclatLayout.setVerticalGroup(
            teclatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Teclat", teclat);

        trackpad.setOpaque(false);

        left_button.setName("left_button"); // NOI18N

        right_button.setName("right_button"); // NOI18N

        middle_button.setName("middle_button"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout trackpadLayout = new javax.swing.GroupLayout(trackpad);
        trackpad.setLayout(trackpadLayout);
        trackpadLayout.setHorizontalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackpadLayout.createSequentialGroup()
                .addComponent(left_button, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middle_button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right_button, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trackpadLayout.setVerticalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackpadLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(middle_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(left_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(right_button, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Trackpad", trackpad);

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
        } else{
            setOpacity((float) (jSlider1.getValue() / 100.0));
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        float auxX = (float)evt.getX() / (float)(((JPanel)evt.getSource()).getWidth());
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
        float auxX = (float)evt.getX() / (float)(((JPanel)evt.getSource()).getWidth());
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
                        if (!inetAddresses.isEmpty()){
                            for (int i = 0; i < inetAddresses.size() && !found;i++) {
                                InetAddress bcst = inetAddresses.get(i).getBroadcast();
                                if(bcst != null){
                                    found = true;
                                    scanPack.setAddress(bcst);
                                    scanPack.setData(name.getBytes());
                                    scanPack.setLength(name.getBytes().length);
                                    scanPack.setPort(client.Client.port);
                                    scanSock.setBroadcast(true);
                                    scanSock.send(scanPack);
                                    scanSock.setSoTimeout(1000);
                                    boolean timeout = false;
                                    while(!timeout){
                                        try{
                                            scanSock.receive(scanPack);
                                            String client_name = new String(scanPack.getData(), 0, scanPack.getLength());
                                            if(!model.contains(client_name)){
                                                model.addElement(client_name);
                                                Emiter e = new Emiter(scanPack.getSocketAddress(), client_name);
                                                llista.add(e);
                                            }
                                        }
                                        catch(SocketTimeoutException ex){
                                            timeout = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (IOException ex) {
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
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton left_button;
    private javax.swing.JButton middle_button;
    private javax.swing.JButton right_button;
    private javax.swing.JPanel tauletaGrafica;
    private javax.swing.JPanel teclat;
    private javax.swing.JPanel trackpad;
    // End of variables declaration//GEN-END:variables
}
