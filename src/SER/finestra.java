package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class finestra extends javax.swing.JFrame {

    private final String defaultLayout = "layoutES.ser";
    private Tecla tecles[];

    public finestra() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Tecla.defaultSize = new Dimension(40, 40);
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
        int i;
        for (i = 0; i < parse.length; i++) {
            tecles[i] = new Tecla(parse[i], null, new Point(Tecla.defaultSize.width * i, 0), null);
            teclat.add(tecles[i]);
        }
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
        //NOT ENOUGH ALSO NEED THE DOWN & UP
        int modifiers = evt.getModifiers();
        Tecla.shiftPressed = (modifiers & KeyEvent.SHIFT_MASK) != 0;
        Tecla.alTPressed = (modifiers & KeyEvent.ALT_MASK) != 0;
        Tecla.controlPressed = (modifiers & KeyEvent.CTRL_MASK) != 0;
        System.out.println("Shift -->" + Tecla.shiftPressed);
        System.out.println("Control -->" + Tecla.controlPressed);
        System.out.println("Alt -->" + Tecla.alTPressed);
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new finestra().setVisible(true);
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
