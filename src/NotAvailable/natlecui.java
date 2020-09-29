/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotAvailable;

import ParellelSession.ParellelSessionC;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Microsoft
 */
public class natlecui extends javax.swing.JFrame {

    /**
     * Creates new form natlecui
     */
    public natlecui() {
        initComponents();
        lecturedrop();
    }

    
         private void lecturedrop(){
          try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            String sql = "SELECT lecture_name FROM lectures";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           
            while(rs.next())
            {
                lecturer.addItem(rs.getString("lecture_name"));             
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
    
    
     public ArrayList<NotAvailableLecClass> natretrieve(){
    ArrayList<NotAvailableLecClass> sessionlist=new ArrayList<>();
     try{
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
          String query="select * from notavailablelec";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(query);
          NotAvailableLecClass pd;
          while(rs.next()){
              pd=new NotAvailableLecClass(rs.getInt("id"),rs.getString("lecturer"),rs.getString("Day"),rs.getString("nat"));
              sessionlist.add(pd);
          }
         
          
           
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
          return sessionlist; 
}
    public void shownat(){
    ArrayList<NotAvailableLecClass> ys=natretrieve();
    DefaultTableModel  model = (DefaultTableModel) natlec.getModel();
    Object[] row =new Object[4];
    for(int i =0;i<ys.size();i++){
        row[0]=ys.get(i).getid();
        row[1]=ys.get(i).getlecturer();
        row[2]=ys.get(i).getday();
        row[3]=ys.get(i).getnat();
       
       
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

        lecturer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        start = new javax.swing.JComboBox<>();
        end = new javax.swing.JComboBox<>();
        day = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        natlec = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerActionPerformed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        start.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30AM", "09:30AM", "10:30AM", "11:30AM", "12:30AM", "13:30AM", "14:30AM", "15:30AM", " " }));

        end.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30AM", "09:30AM", "10:30AM", "11:30AM", "12:30AM", "13:30AM", "14:30AM", "15:30AM", "16:30AM", "17:30AM", "18:30AM" }));
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        natlec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "lecturer", "day", "not available sessions"
            }
        ));
        natlec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                natlecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(natlec);

        jPanel3.setBackground(new java.awt.Color(61, 42, 121));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("TIME TABLE SYSTEM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel12.setText("Lecture Not Available Sessions");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Day");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Not Available Time");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Lecture");

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel15)))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(day, 0, 145, Short.MAX_VALUE)
                            .addComponent(lecturer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(313, 313, 313)
                                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel14))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addGap(97, 104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String y;
        y=lecturer.getSelectedItem().toString();
        
        String days;
        days=day.getSelectedItem().toString();
        
        
       String starttime;
        starttime=start.getSelectedItem().toString();
        
         String endtime;
        endtime=end.getSelectedItem().toString();
        
        String timee=starttime+"-"+endtime;
        
          try{
            
            
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            String query="insert into notavailablelec (lecturer,day,time) VALUES('"+y+"','"+days+"','"+timee+"')";
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
             pst.executeUpdate();
           
         DefaultTableModel model=(DefaultTableModel)natlec.getModel();
           model.setRowCount(0);
           shownat();
            
            
          
         }catch(Exception e){
                  e.printStackTrace();
                  }    
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endActionPerformed

    private void natlecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_natlecMouseClicked
        // TODO add your handling code here:
        int i = natlec.getSelectedRow();
        TableModel model=natlec.getModel();
    }//GEN-LAST:event_natlecMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
                  //   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");

           int row=natlec.getSelectedRow();
           String value=(natlec.getModel().getValueAt(row, 0).toString());
           String query="delete from notavailablelec where id="+value;
           java.sql.PreparedStatement pst=conn.prepareStatement(query);
           pst.executeUpdate();
           DefaultTableModel model=(DefaultTableModel)natlec.getModel();
            model.setRowCount(0);
            shownat();
            JOptionPane.showMessageDialog(null,"deleted");
           
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(natlecui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(natlecui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(natlecui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(natlecui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new natlecui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> day;
    private javax.swing.JComboBox<String> end;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lecturer;
    private javax.swing.JTable natlec;
    private javax.swing.JComboBox<String> start;
    // End of variables declaration//GEN-END:variables
}
