package SER;

import java.awt.Dimension;
import java.awt.Point;
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
    private Tecla[] tecles;
    
    public void posaTecles(){
        
    }
    public finestra() throws FileNotFoundException, IOException {

        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName("teclat"); // NOI18N

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
            .addGap(0, 392, Short.MAX_VALUE)
        );
        teclatLayout.setVerticalGroup(
            teclatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Teclat", teclat);

        javax.swing.GroupLayout trackpadLayout = new javax.swing.GroupLayout(trackpad);
        trackpad.setLayout(trackpadLayout);
        trackpadLayout.setHorizontalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        trackpadLayout.setVerticalGroup(
            trackpadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Trackpad", trackpad);

        javax.swing.GroupLayout tauletaGraficaLayout = new javax.swing.GroupLayout(tauletaGrafica);
        tauletaGrafica.setLayout(tauletaGraficaLayout);
        tauletaGraficaLayout.setHorizontalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        tauletaGraficaLayout.setVerticalGroup(
            tauletaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tauleta gràfica", tauletaGrafica);

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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tauletaGrafica;
    private javax.swing.JPanel teclat;
    private javax.swing.JPanel trackpad;
    // End of variables declaration//GEN-END:variables
}
