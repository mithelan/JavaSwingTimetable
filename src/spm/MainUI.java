/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import Lecturer.LecturerView;
import Lecturer.LecuturerInsert;
import Subject.SubjectInsert;
import Subject.SubjectView;

/**
 *
 * @author ASUS
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lecdetail = new javax.swing.JButton();
        addlec = new javax.swing.JButton();
        subjectdetail = new javax.swing.JButton();
        addsub = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lecdetail.setText("Lecturer Details");
        lecdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecdetailActionPerformed(evt);
            }
        });

        addlec.setText("Add Lecturer Information");
        addlec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlecActionPerformed(evt);
            }
        });

        subjectdetail.setText("Subject Details");
        subjectdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectdetailActionPerformed(evt);
            }
        });

        addsub.setText("Add Subject Details");
        addsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addlec)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lecdetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subjectdetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addsub, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lecdetail)
                .addGap(26, 26, 26)
                .addComponent(subjectdetail)
                .addGap(29, 29, 29)
                .addComponent(addlec)
                .addGap(18, 18, 18)
                .addComponent(addsub)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lecdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecdetailActionPerformed
        // TODO add your handling code here:
        
        
        LecturerView lv=new LecturerView();
        lv.setVisible(true);
    }//GEN-LAST:event_lecdetailActionPerformed

    private void subjectdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectdetailActionPerformed
        // TODO add your handling code here:
              SubjectView lv=new SubjectView();
                lv.setVisible(true);
        
    }//GEN-LAST:event_subjectdetailActionPerformed

    private void addlecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlecActionPerformed
        // TODO add your handling code here:
           LecuturerInsert lv=new LecuturerInsert();
                lv.setVisible(true);
        
    }//GEN-LAST:event_addlecActionPerformed

    private void addsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsubActionPerformed
        // TODO add your handling code here:
            SubjectInsert lv=new SubjectInsert();
                lv.setVisible(true);
    }//GEN-LAST:event_addsubActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addlec;
    private javax.swing.JButton addsub;
    private javax.swing.JButton lecdetail;
    private javax.swing.JButton subjectdetail;
    // End of variables declaration//GEN-END:variables
}
