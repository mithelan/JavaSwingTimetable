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
                String sqlquery="select DISTINCT year from session ";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
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
        String sqlquery="select subject from session where year='"+yearcombo1+"'";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
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
        String sqlquery="select subject from session where year='"+yearcombo1+"'";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
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
        String sqlquery="select subject from session where year='"+yearcombo1+"'";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        parelleltbl = new javax.swing.JTable();
        session1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        session2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        session3 = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ampm = new javax.swing.JComboBox<>();
        days = new javax.swing.JComboBox<>();
        neram = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        yearcombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Parellel Sessions");

        parelleltbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ParID", "Day", "Start time", "Duration", "Session 1", "Session2", "Session3"
            }
        ));
        jScrollPane1.setViewportView(parelleltbl);

        session1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Session 1");

        jLabel3.setText("Session 2");

        session2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Session 3");

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

        jLabel5.setText(" Days ");

        jLabel6.setText("Duration");

        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });

        jLabel7.setText("Start Time");

        ampm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        neram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17:30", "18:30" }));

        jLabel8.setText("year");

        yearcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        yearcombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearcomboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(session3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(session2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(session1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(32, 32, 32)
                                        .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(45, 45, 45)
                                        .addComponent(neram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(duration)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(yearcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(16, 16, 16)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(neram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(session1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(session2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(session3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(add)
                .addContainerGap(13, Short.MAX_VALUE))
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
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/SPM","root","");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> neram;
    private javax.swing.JTable parelleltbl;
    private javax.swing.JComboBox<String> session1;
    private javax.swing.JComboBox<String> session2;
    private javax.swing.JComboBox<String> session3;
    private javax.swing.JComboBox<String> yearcombo;
    // End of variables declaration//GEN-END:variables
}
