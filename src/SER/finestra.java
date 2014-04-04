package SER;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class finestra extends javax.swing.JFrame {
    
    private char[] tecles;
    private final String defaultLayout = "layoutES.ser";

    public finestra() {
        Tecla.defaultSize = new Dimension(40, 40);
        Tecla.defaultAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Tecla tecla = (Tecla)(ae.getSource());
                //Stub envio tecla
                System.out.println(tecla.getContent());
                Point location = tecla.getLocation();        
                location.y += tecla.getHeight();
                tecla.setLocation(location);
            }
        };
        tecles = new char []{'Q','W','E','R','T','Y','U','I','O','P'};
        initComponents();
        String str;
        str = "º,ª,\\,1,2,3";
        String[] splited = str.split(",");
        
//        Point posicio = new Point(0,0);
//        Tecla t;
//        for (int i = 0; i < tecles.length; i++) {
//            t = new Tecla(""+tecles[i],null, posicio, tecles[i],null);
//            posicio.x+=(Tecla.defaultSize.width);
//            teclat.add(t);
//        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        teclat = new javax.swing.JPanel();
        trackpad = new javax.swing.JPanel();
        tauletaGrafica = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        teclat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.print(evt.getKeyChar());
    }//GEN-LAST:event_formKeyPressed

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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tauletaGrafica;
    private javax.swing.JPanel teclat;
    private javax.swing.JPanel trackpad;
    // End of variables declaration//GEN-END:variables
}
