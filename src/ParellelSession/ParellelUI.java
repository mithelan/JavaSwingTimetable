/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParellelSession;

import ConsecutiveSession.Consecsession;
import com.mysql.jdbc.PreparedStatement;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Microsoft
 */
public class ParellelUI extends javax.swing.JFrame {
DatePicker date;
    
    /**
     * Creates new form ParellelUI
     */
    public ParellelUI() {
        initComponents();
       session1();
       session2();
       session3();
                showparellelc();
                String sqlquery="select DISTINCT year from years ";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
          PreparedStatement  pst= (PreparedStatement) conn.prepareStatement(sqlquery);
          ResultSet rs =null;
          rs=pst.executeQuery();
          while(rs.next()){
              String yearname = rs.getString(1);
              yearcombo.addItem(yearname);
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    String yearcombo1;
    private void session1(){
        String sqlquery="select sessionTot from session where studentGroup like'%"+yearcombo1+"%'";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
          PreparedStatement  pst= (PreparedStatement) conn.prepareStatement(sqlquery);
          ResultSet rs =null;
          rs=pst.executeQuery();
          while(rs.next()){
              String yearname = rs.getString(1);
              session1.addItem(yearname);
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void session2(){
String sqlquery="select sessionTot from session where studentGroup like'%"+yearcombo1+"%'";        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
          PreparedStatement  pst= (PreparedStatement) conn.prepareStatement(sqlquery);
          ResultSet rs =null;
          rs=pst.executeQuery();
          while(rs.next()){
              String yearname = rs.getString(1);
              session2.addItem(yearname);
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void session3(){
        

String sqlquery="select sessionTot from session where studentGroup like'%"+yearcombo1+"%'";         
        try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
          PreparedStatement  pst= (PreparedStatement) conn.prepareStatement(sqlquery);
          ResultSet rs =null;
          rs=pst.executeQuery();
          while(rs.next()){
              String yearname = rs.getString(1);
              session3.addItem(yearname);
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public ArrayList<ParellelSessionC> psessiondetailsretrieve(){
    ArrayList<ParellelSessionC> sessionlist=new ArrayList<>();
     try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/SPM","root","");
          String query="select * from psessions";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(query);
          ParellelSessionC pd;
          while(rs.next()){
              pd=new ParellelSessionC(rs.getInt("id"),rs.getString("startdate"),rs.getString("starttime"),rs.getInt("duration"),rs.getString("session1"),rs.getString("session2"),rs.getString("session3"));
              sessionlist.add(pd);
          }
         
          
           
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
          return sessionlist; 
}
    public void showparellelc(){
    ArrayList<ParellelSessionC> ys=psessiondetailsretrieve();
    DefaultTableModel  model = (DefaultTableModel) parelleltbl.getModel();
    Object[] row =new Object[7];
    for(int i =0;i<ys.size();i++){
        row[0]=ys.get(i).getid();
        row[1]=ys.get(i).getstartdate();
        row[2]=ys.get(i).getstarttime();
        row[3]=ys.get(i).getduration();
        row[4]=ys.get(i).getsession1();
        row[5]=ys.get(i).getsession2();
        row[6]=ys.get(i).getsession3();
       
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

        jScrollPane1 = new javax.swing.JScrollPane();
        parelleltbl = new javax.swing.JTable();
        session1 = new javax.swing.JComboBox<>();
        session2 = new javax.swing.JComboBox<>();
        session3 = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        duration = new javax.swing.JTextField();
        ampm = new javax.swing.JComboBox<>();
        days = new javax.swing.JComboBox<>();
        neram = new javax.swing.JComboBox<>();
        yearcombo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parelleltbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ParID", "Day", "Start time", "Duration", "Session 1", "Session2", "Session3"
            }
        ));
        parelleltbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parelleltblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(parelleltbl);

        session1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session1ActionPerformed(evt);
            }
        });

        session2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session2ActionPerformed(evt);
            }
        });

        session3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session3ActionPerformed(evt);
            }
        });

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });

        ampm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        neram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17:30", "18:30" }));

        yearcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        yearcombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearcomboItemStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(61, 42, 121));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("TIME TABLE SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel10.setText("Parellel Sessions");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Day");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Start Time");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Duration");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Year");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Session 1");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Session 2");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Session 3");

        jButton1.setText("Delete");
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(session1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearcombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(duration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(neram, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(179, 179, 179)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(session3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(session2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(1278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(neram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(session1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(session2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(session3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(jButton1))
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    
    
    private void session1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_session1ActionPerformed
        // TODO add your handling code here:
        
        
  
        
        
        
    }//GEN-LAST:event_session1ActionPerformed

    
    
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
         try{
             
             
              String s1;
            s1 = session1.getSelectedItem().toString();
            String s2;
            s2 = session2.getSelectedItem().toString();
            String s3;
            s3 = session3.getSelectedItem().toString();
            String time;
            time=ampm.getSelectedItem().toString();
           String day;
            day=days.getSelectedItem().toString();
             
       String mani;
       mani =neram.getSelectedItem().toString();
            
            String starttimee=mani+" "+time;
            
            
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            String query="insert into psessions (startdate,starttime,duration,session1,session2,session3) VALUES('"+day+"','"+starttimee+"','"+duration.getText()+"','"+s1+"','"+s2+"','"+s3+"')";
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
             pst.executeUpdate();
           
           DefaultTableModel model=(DefaultTableModel)parelleltbl.getModel();
            model.setRowCount(0);
            showparellelc();
            
            
          
         }catch(Exception e){
                  e.printStackTrace();
                  }    
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_addActionPerformed

    private void session2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_session2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_session2ActionPerformed

    private void session3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_session3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_session3ActionPerformed

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationActionPerformed

    private void yearcomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearcomboItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            
           yearcombo1 =yearcombo.getSelectedItem().toString();
           session1.removeAllItems();
           session1();
           session2.removeAllItems();
           session2();
           session3.removeAllItems();
           session3();
           
            
        }
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_yearcomboItemStateChanged

    private void parelleltblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parelleltblMouseClicked
        // TODO add your handling code here:
           int i = parelleltbl.getSelectedRow();
        TableModel model=parelleltbl.getModel();
        
        
        
    }//GEN-LAST:event_parelleltblMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
                  //   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");

           int row=parelleltbl.getSelectedRow();
           String value=(parelleltbl.getModel().getValueAt(row, 0).toString());
           String query="delete from psessions where id="+value;
           java.sql.PreparedStatement pst=conn.prepareStatement(query);
           pst.executeUpdate();
           DefaultTableModel model=(DefaultTableModel)parelleltbl.getModel();
            model.setRowCount(0);
            showparellelc();
            JOptionPane.showMessageDialog(null,"deleted");
           
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
        
        
        
        
        
        
        
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
            java.util.logging.Logger.getLogger(ParellelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParellelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParellelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParellelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParellelUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> ampm;
    private javax.swing.JComboBox<String> days;
    private javax.swing.JTextField duration;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> neram;
    private javax.swing.JTable parelleltbl;
    private javax.swing.JComboBox<String> session1;
    private javax.swing.JComboBox<String> session2;
    private javax.swing.JComboBox<String> session3;
    private javax.swing.JComboBox<String> yearcombo;
    // End of variables declaration//GEN-END:variables
}
