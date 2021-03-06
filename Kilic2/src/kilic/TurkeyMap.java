/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kilic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author askilic
 */
public class TurkeyMap extends javax.swing.JFrame {

    /**
     * Creates new form TurkeyMap
     */
    public TurkeyMap() {
        initComponents();
        fillPixel();
    }

    public TurkeyMap(List<List<Integer>> path) {
        initComponents();
        fillPixel();
        this.path = path;
    }
    List<List<Integer>> path;
    double[][] pixel;

    private void fillPixel() { // kordinatları okur 
        pixel = new double[81][2];
        File f = new File("xy.txt");
        if (f.exists()) {
            System.out.println("Dosya vardır.");
        } else {
            System.out.println("Dosya yoktur.");
        }
        FileReader fr;
        try {

            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i, j;
            for (i = 0; i < 81; i++) {
                String yazi = br.readLine();
                String[] yazilar = yazi.split(" ");
                for (j = 0; j < 2; j++) {
                    pixel[i][j] = Double.parseDouble(yazilar[j]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TurkeyMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TurkeyMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*for(int i=0;i<81;i++){
            for(int j=0;j<2;j++){
                System.out.print("-- "+pixel[i][j]+" --");
            }
            System.out.println();
        }*/
    }

    /**
     *
     * @param g
     */
    public void drawLines(Graphics g) {//nereler cizgi atılacagını secen method
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));// cizgi boyutunu ayarlar
        double x1, y1, x2, y2; // cizilecek kordinatlar
        x1 = x2 = y1 = y2 = 0;
        //double k[] = new double[2];
        int i, j;
        for (i = 0; i < path.size(); i++) {

            List<Integer> l = path.get(i);
            if (i > (path.size()) / 2) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.red);
            }
            for (j = 0; j < l.size() - 1; j++) {

                x1 = pixel[l.get(j)][0];
                y1 = pixel[l.get(j)][1];

                x2 = pixel[l.get(j + 1)][0];
                y2 = pixel[l.get(j + 1)][1];
                Line2D lin = new Line2D.Double(x1, y1, x2, y2);
                g2d.draw(lin);

            }
            //k[0] = x2;
            //k[1] = y2;
        }
        /*x1 = k[0];
        y1 = k[1];
        x2 = 294.0;
        y2 = 134.0;
        Line2D lin = new Line2D.Double(x1, y1, x2, y2);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(lin);*/

    }

    public void paint(Graphics g) { // cizgi atma methodu
        super.paint(g);
        drawLines(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        MapPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, -1, -1));

        MapPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kilic/map.png"))); // NOI18N
        getContentPane().add(MapPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 649));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); // back tusu ile suanlık acık olan haritayı kapatır kapatır 
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(TurkeyMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TurkeyMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TurkeyMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TurkeyMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TurkeyMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel MapPic;
    // End of variables declaration//GEN-END:variables
}
