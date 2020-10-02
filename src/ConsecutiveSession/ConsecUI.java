/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsecutiveSession;

import com.mysql.jdbc.PreparedStatement;
import group.Grpdetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Microsoft
 */
public class ConsecUI extends javax.swing.JFrame {

    /**
     * Creates new form ConsecUI
     */
    public ConsecUI() {
        initComponents();
        lecturedrop();
        labdrop();
        tutorialdrop();
        showcsec();
    }

    
    
    private void lecturedrop(){
          try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            String sql = "SELECT sessionTot FROM session";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           
            while(rs.next())
            {
                lecture.addItem(rs.getString("sessionTot"));             
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
       
    private void labdrop(){
          try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            String sql = "SELECT sessionTot FROM session";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           
            while(rs.next())
            {
                lab.addItem(rs.getString("sessionTot"));             
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
    
      private void tutorialdrop(){
          try{
            Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
                String q="Tutorial";
            String sql = "SELECT sessionTot FROM session";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           
            while(rs.next())
            {
                tutorial.addItem(rs.getString("sessionTot"));             
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
        csessiontab = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lecture = new javax.swing.JComboBox<>();
        lab = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        tutorial = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        csessiontab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ConID", "Lecture", "Lab", "Tutorial"
            }
        ));
        csessiontab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csessiontabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(csessiontab);

        lab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA" }));

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        tutorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA" }));

        jPanel1.setBackground(new java.awt.Color(61, 42, 121));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("TIME TABLE SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel9.setText("Consecutive Sessions");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Lab");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Tutorial");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Lecturer ");

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
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
                        .addGap(238, 238, 238)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lecture, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Delete)))))
                .addGap(51, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(Delete))
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
         try{
              String lec;
            lec = lecture.getSelectedItem().toString();
            String labb;
            labb = lab.getSelectedItem().toString();
            String ttutorial;
            ttutorial = tutorial.getSelectedItem().toString();
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
            if( lec.isEmpty() || labb.isEmpty() || ttutorial.isEmpty()  ){
                String message="All Field Should be filled";
                 JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
            }else{
            String query="insert into csessions (lecture,lab,tutorial)VALUES('"+lec+"','"+labb+"','"+ttutorial+"')";
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
             pst.executeUpdate();
            }
           DefaultTableModel model=(DefaultTableModel)csessiontab.getModel();
            model.setRowCount(0);
            showcsec();
            
            
          
         }catch(Exception e){
                  e.printStackTrace();
                  }    
        
        
    }//GEN-LAST:event_addActionPerformed

    private void csessiontabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csessiontabMouseClicked
        // TODO add your handling code here:
             int i = csessiontab.getSelectedRow();
        TableModel model=csessiontab.getModel();
    }//GEN-LAST:event_csessiontabMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
                  //   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");

           int row=csessiontab.getSelectedRow();
           String value=(csessiontab.getModel().getValueAt(row, 0).toString());
           String query="delete from csessions where id="+value;
           java.sql.PreparedStatement pst=conn.prepareStatement(query);
           pst.executeUpdate();
           DefaultTableModel model=(DefaultTableModel)csessiontab.getModel();
            model.setRowCount(0);
            showcsec();
            JOptionPane.showMessageDialog(null,"deleted");
           
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
        
        
        
        
        
    }//GEN-LAST:event_DeleteActionPerformed

     public ArrayList<Consecsession> csessiondetailsretrieve(){
    ArrayList<Consecsession> sessionlist=new ArrayList<>();
     try{
           Class.forName("com.mysql.jdbc.Driver");
           
         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");
                //     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");

          String query="select * from csessions";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(query);
          Consecsession pd;
          while(rs.next()){
              pd=new Consecsession(rs.getInt("id"),rs.getString("lecture"),rs.getString("lab"),rs.getString("tutorial"));
              sessionlist.add(pd);
          }
         
          
           
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
          return sessionlist; 
}
    public void showcsec(){
    ArrayList<Consecsession> ys=csessiondetailsretrieve();
    DefaultTableModel  model = (DefaultTableModel) csessiontab.getModel();
    Object[] row =new Object[4];
    for(int i =0;i<ys.size();i++){
        row[0]=ys.get(i).getid();
        row[1]=ys.get(i).getlecture();
        row[2]=ys.get(i).getlab();
        row[3]=ys.get(i).gettutorial();
       
        model.addRow(row);

                
    }
    }
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(ConsecUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsecUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsecUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsecUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsecUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton add;
    private javax.swing.JTable csessiontab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lab;
    private javax.swing.JComboBox<String> lecture;
    private javax.swing.JComboBox<String> tutorial;
    // End of variables declaration//GEN-END:variables
}
