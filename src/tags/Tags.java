/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import group.Grpdetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import spm.Home;

/**
 *
 * @author Microsoft
 */
public class Tags extends javax.swing.JFrame {

    /**
     * Creates new form Tags
     */
    public Tags() {
        initComponents();
        showtag();
    }

     public ArrayList<Tagdetails> tagdetailsretrieve(){
    ArrayList<Tagdetails> taglist=new ArrayList<>();
     try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/SPM","root","Vithu719@");
          String query="select * from tags";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(query);
          Tagdetails pd;
          while(rs.next()){
              pd=new Tagdetails(rs.getInt("id"),rs.getString("tag"));
              taglist.add(pd);
          }
         
          
           
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
          return taglist; 
}
    public void showtag(){
    ArrayList<Tagdetails> ys=tagdetailsretrieve();
    DefaultTableModel  model = (DefaultTableModel) tagtable.getModel();
    Object[] row =new Object[2];
    for(int i =0;i<ys.size();i++){
        row[0]=ys.get(i).getid();
        row[1]=ys.get(i).gettag();
       
        model.addRow(row);

                
    }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tag = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tagtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tag");

        add.setBackground(new java.awt.Color(0, 0, 255));
        add.setForeground(new java.awt.Color(240, 240, 240));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 0, 204));
        update.setForeground(new java.awt.Color(240, 240, 240));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 0, 204));
        delete.setForeground(new java.awt.Color(240, 240, 240));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        tagtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TAG"
            }
        ));
        tagtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tagtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tagtable);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addComponent(add))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(update)
                            .addComponent(delete)
                            .addComponent(jButton1))))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/SPM","root","Vithu719@");
           int row=tagtable.getSelectedRow();
           String value=(tagtable.getModel().getValueAt(row, 0).toString());
           String query="delete from tags where id="+value;
           PreparedStatement pst=conn.prepareStatement(query);
           pst.executeUpdate();
           DefaultTableModel model=(DefaultTableModel)tagtable.getModel();
            model.setRowCount(0);
            showtag();
              tag.setText("");
            JOptionPane.showMessageDialog(null,"deleted");
           
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
          try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/SPM","root","Vithu719@");
           int row=tagtable.getSelectedRow();
           String value=(tagtable.getModel().getValueAt(row, 0).toString());
           String query="UPDATE tags SET tag=? where id="+value;
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, tag.getText());
            
            pst.executeUpdate();
            DefaultTableModel model=(DefaultTableModel)tagtable.getModel();
            model.setRowCount(0);
            showtag();
            tag.setText("");
            JOptionPane.showMessageDialog(null,"updated");
          }catch(Exception e){
                  e.printStackTrace();
                  }
        
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/SPM","root","Vithu719@");
            String query="insert into tags (tag) values (?)";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, tag.getText());
           
           
           
            pst.executeUpdate();
            DefaultTableModel model=(DefaultTableModel)tagtable.getModel();
            model.setRowCount(0);
            showtag();
              tag.setText("");
            
          
         }catch(Exception e){
                  e.printStackTrace();
                  }
        
        
    }//GEN-LAST:event_addActionPerformed

    private void tagtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tagtableMouseClicked
        // TODO add your handling code here:
        int i = tagtable.getSelectedRow();
        TableModel model=tagtable.getModel();
        tag.setText(model.getValueAt(i, 1).toString());
        
        
        
        
    }//GEN-LAST:event_tagtableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Home home =new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tags().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tag;
    private javax.swing.JTable tagtable;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
