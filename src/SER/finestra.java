package SER;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class finestra extends javax.swing.JFrame {

    private final String defaultLayout = "layoutES.ser";
    private Tecla tecles[];

    public void posaTecles() {

    }

    private class rawData {
        public String datos;
        public double relWidth, relHeight;
    }

    public finestra() throws FileNotFoundException, IOException {
        ArrayList<ArrayList<rawData>> matriu = new ArrayList<>();
        ArrayList<ArrayList<Tecla>> teclatData = new ArrayList<>();
        ArrayList<Double> tamanys = new ArrayList<Double>();
        this.setUndecorated(true);
        initComponents();
        jSlider1.setMaximum(100);
//        BufferedReader br = new BufferedReader(new FileReader(defaultLayout));
//        ArrayList<rawData> linia;
//        rawData raw;
//        int i = 0;
//        String line = br.readLine();
//        while (line != null) {
//            linia = new ArrayList<>();
//            tamanys.add(0.0);
//            while (line != null && !line.equals("NEWLINE")) {
//                raw = new rawData();
//                String[] split;
//                String[] size;
//                if (line.startsWith("\\")) {
//                    split = line.split(">");
//                    size = split[1].split("<");
//                } else {
//                    split = line.split(";");
//                    size = split[1].split(",");
//                }
//                raw.datos = split[0];
//                raw.relWidth = Double.parseDouble(size[0]);
//                raw.relHeight = Double.parseDouble(size[1]);
//                Double get = tamanys.get(i) + Double.parseDouble(size[0]);
//                tamanys.set(i, get);
//                linia.add(raw);
//                line = br.readLine();
//            }
//            matriu.add(linia);
//            i++;
//            line = br.readLine();
//        }
//        br.close();
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize(screenSize);
//        int num_files = matriu.size();
//        for (i = 0; i < num_files; i++) {
//            linia = matriu.get(i);
//            Double width_size = tamanys.get(i);
//            double accum = 0.0;
//            ArrayList<Tecla> teclaLine = new ArrayList<>();
//            for (rawData linia1 : linia) {
//                Dimension dim = new Dimension((int) ((screenSize.width / width_size) * linia1.relWidth), (int) ((screenSize.height / num_files) * linia1.relHeight));
//                if (!linia1.datos.equals("EMPTY")) {
//                    Point p = new Point((int) (accum * (screenSize.width / width_size)), i * (screenSize.height / num_files));
//                    System.out.println(p);
//                    System.out.println(dim);
//                    Tecla t = new Tecla(linia1.datos, dim, p);
//                    teclaLine.add(t);
//                    teclat.add(t);
//                }
//                accum += linia1.relWidth;
//            }
//            teclatData.add(teclaLine);
//        }
//        teclat.setFocusable(true);
//        teclat.requestFocusInWindow();
//        teclat.setFocusTraversalKeysEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTabbedPane1 = new javax.swing.JTabbedPane();
        teclat = new javax.swing.JPanel();
        trackpad = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tauletaGrafica = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName("teclat"); // NOI18N

        teclat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teclat.setName("teclat"); // NOI18N
        teclat.setOpaque(false);
        teclat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teclatKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout teclatLayout = new javax.swing.GroupLayout(teclat);
        teclat.setLayout(teclatLayout);
        teclatLayout.setHorizontalGroup(
            teclatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1212, Short.MAX_VALUE)
        );
        teclatLayout.setVerticalGroup(
            teclatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Teclat", teclat);

        trackpad.setOpaque(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton3, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), jButton2, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout trackpadLayout = new javax.swing.GroupLayout(trackpad);
        trackpad.setLayout(trackpadLayout);
        trackpadLayout.setHorizontalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackpadLayout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
        );
        trackpadLayout.setVerticalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackpadLayout.createSequentialGroup()
                .addGap(0, 389, Short.MAX_VALUE)
                .addGroup(trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Trackpad", trackpad);

        tauletaGrafica.setOpaque(false);

        javax.swing.GroupLayout tauletaGraficaLayout = new javax.swing.GroupLayout(tauletaGrafica);
        tauletaGrafica.setLayout(tauletaGraficaLayout);
        tauletaGraficaLayout.setHorizontalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tauletaGraficaLayout.createSequentialGroup()
                .addGroup(tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 1163, Short.MAX_VALUE))
        );
        tauletaGraficaLayout.setVerticalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tauletaGraficaLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel1.setText("Opacity");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1012, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 375, Short.MAX_VALUE))
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

        jTabbedPane1.getAccessibleContext().setAccessibleName("Teclat");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teclatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teclatKeyPressed
        //de moment aixo no cal    
    }//GEN-LAST:event_teclatKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //TODO ferho al principi i aqui nomes comprovar una variable
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
            System.out.println("Transparencia no suportada per el sistema operatiu");
        }
        setOpacity((float) (jSlider1.getValue() / 100.0));
    }//GEN-LAST:event_jSlider1StateChanged

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new finestra().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(finestra.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(finestra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tauletaGrafica;
    private javax.swing.JPanel teclat;
    private javax.swing.JPanel trackpad;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
