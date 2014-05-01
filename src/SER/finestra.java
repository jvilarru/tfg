package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class finestra extends javax.swing.JFrame {
    public static final int NUM_TECLES = 17;
    private final String defaultLayout = "layoutES.ser";
    private Tecla tecles[];
    
    public void posaTecles(){
        
    }
    public finestra() throws FileNotFoundException, IOException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Tecla.defaultSize = new Dimension[4];
        Tecla.defaultSize[0] = new Dimension(40, 40);
        //<editor-fold defaultstate="collapsed" desc="Inicialitzacio dels valors per defecte de les tecles">
        //TODO ferho en funcio de la pantalla la seguent instruccio es la clau 
        //per a aixo, tambe ens haurem de preocupar per el tamany de la lletra
        //i per si ens redimensionen la finestra
        Rectangle bounds = teclat.getBounds();
        Tecla.defaultSize = new Dimension[6];
        Tecla.defaultSize[0] = new Dimension(bounds.width/17, 40);
        //fi-TODO
        Tecla.defaultAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Tecla tecla = (Tecla) (ae.getSource());
                //Stub envio tecla
                //TODO: ferho com a part de la clase Tecla?
                System.out.println(tecla.getContent());
            }
        };
        this.setUndecorated(true);
        initComponents();
        this.setSize(screenSize);        
        
        String parse[] = new String[]{"q,Q,@,q,Q,@", "w,W,ł,w,W,ł"};
        tecles = new Tecla[parse.length];

        //</editor-fold>
        tecles = new Tecla[NUM_TECLES];
        BufferedReader br = new BufferedReader(new FileReader(defaultLayout));

        int i;

        int row=0;
        for (i = 0; i < NUM_TECLES; i++) {
            tecles[i] = new Tecla(br.readLine(), null, new Point(Tecla.defaultSize[row].width * i, 0), null,row);
            teclat.add(tecles[i]);
        }
        br.close();
        teclat.setFocusable(true);
        teclat.requestFocusInWindow();
        teclat.setFocusTraversalKeysEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        teclat = new javax.swing.JPanel();
        trackpad = new javax.swing.JPanel();
        tauletaGrafica = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName("teclat"); // NOI18N
        jTabbedPane1.setOpaque(true);

        teclat.setName("teclat"); // NOI18N
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

        javax.swing.GroupLayout trackpadLayout = new javax.swing.GroupLayout(trackpad);
        trackpad.setLayout(trackpadLayout);
        trackpadLayout.setHorizontalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1212, Short.MAX_VALUE)
        );
        trackpadLayout.setVerticalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Trackpad", trackpad);

        javax.swing.GroupLayout tauletaGraficaLayout = new javax.swing.GroupLayout(tauletaGrafica);
        tauletaGrafica.setLayout(tauletaGraficaLayout);
        tauletaGraficaLayout.setHorizontalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1212, Short.MAX_VALUE)
        );
        tauletaGraficaLayout.setVerticalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tauleta gràfica", tauletaGrafica);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teclatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teclatKeyPressed
        //de moment aixono cal
        System.out.println(evt.getKeyChar() + "-->" + evt.getKeyCode());
//        if(evt.getSource().equals(teclat))
//            System.out.println("yupi");
    }//GEN-LAST:event_teclatKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        
        System.out.println(jSlider1.getValue());
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tauletaGrafica;
    private javax.swing.JPanel teclat;
    private javax.swing.JPanel trackpad;
    // End of variables declaration//GEN-END:variables
}
