/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workingdays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M.ANJANAN
 */
public class WorkingDaysView extends javax.swing.JFrame {

    /**
     * Creates new form WorkingDaysView
     */
    public WorkingDaysView() {
        initComponents();
        populateBatch();
        populateTable();
        populateWorkingDaysValues();
    }

    public ResultSet DatabaseConnectionSelect(String query) {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            rs = statement.executeQuery(query);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
        }

        return rs;
    }

    public void populateTable() {

        String comboBoxValue = cbBatch.getSelectedItem().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM timeslots where batch ='" + comboBoxValue + "'");

            //adding to table straight from resultset
            while (jTable1.getRowCount() > 0) {
                ((DefaultTableModel) jTable1.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) jTable1.getModel()).insertRow(rs.getRow() - 1, row);
            }

//while (rs.next()) {
//         String type = rs.getString("type");
//         String start_time = rs.getString("start_time");
//         System.out.println(start_time);
//    
//}
            //   Object[] row = { data1, data2, data3, data4 };
  //  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
   // model.addRow(row);
        } catch (SQLException e) {
            Logger.getLogger(WorkingDaysView.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkingDaysView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void populateWorkingDaysValues() {

        String comboBoxValue = cbBatch.getSelectedItem().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");

              Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM workingdays where batch ='" + comboBoxValue + "'");

            while (rs.next()) {
                int daysPerWeek = rs.getInt("no_working_days");
                int timeperDay = rs.getInt("working_hours");
                String days = rs.getString("days");
                int hours = timeperDay / 60;
                int minutes = timeperDay % 60;
                jLabel5.setText(String.valueOf(daysPerWeek));
                jLabel11.setText(hours + "hours " + minutes + "minutes");
                jLabel9.setText(days);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void populateBatch() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

              Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM workingdays");

            while (rs.next()) {
                String data;
                data = rs.getString("batch");

                cbBatch.addItem(new ComboItem(data, data));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDeleteWorkingday = new javax.swing.JButton();
        btnDeleteTimeSlot = new javax.swing.JButton();
        cbTimeSlot = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbBatch = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnViewAddWorkdays = new javax.swing.JButton();
        btnTimeSlotAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Working days per week:");

        jLabel4.setText("Working Time Per day:");

        jLabel6.setText("Working Days:");

        jLabel5.setBackground(new java.awt.Color(102, 255, 204));
        jLabel5.setText("jLabel5");

        jLabel9.setText("jLabel9");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TimeSlot_id", "Batch", "Type", "Starting_time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnDeleteWorkingday.setText("Delete");
        btnDeleteWorkingday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteWorkingdayActionPerformed(evt);
            }
        });

        btnDeleteTimeSlot.setText("Delete");

        cbTimeSlot.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Select batch");

        cbBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBatchActionPerformed(evt);
            }
        });

        jLabel11.setText("jLabel11");

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        jPanel1.setForeground(new java.awt.Color(102, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));
        jPanel2.setForeground(new java.awt.Color(102, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jLabel12.setBackground(new java.awt.Color(51, 255, 204));
        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Working Days And Hours");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setBackground(new java.awt.Color(51, 255, 204));
        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("TimeSlots");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnViewAddWorkdays.setText("ADD WORKING DAYS & HOURS");
        btnViewAddWorkdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAddWorkdaysActionPerformed(evt);
            }
        });

        btnTimeSlotAdd.setText("ADD TIMESLOTS");
        btnTimeSlotAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeSlotAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeleteWorkingday)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteTimeSlot)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(btnViewAddWorkdays)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTimeSlotAdd))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addGap(28, 154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteWorkingday)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewAddWorkdays)
                            .addComponent(btnTimeSlotAdd))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(cbTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteTimeSlot)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteWorkingdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteWorkingdayActionPerformed
        // TODO add your handling code here:

        String comboBoxBatch = cbBatch.getSelectedItem().toString();
        String query = "delete from workingdays where batch ='" + comboBoxBatch + "'";
        String queryTimeSlot = "delete from timeslots where batch ='" + comboBoxBatch + "'";
        // DatabaseConnection.deleteQuery(query);
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
          conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();

            stmt.executeUpdate(query);
            stmt.executeUpdate(queryTimeSlot);
            JOptionPane.showMessageDialog(null, "Record is deleted from the table successfully..................");
            System.out.println("Record is deleted from the table successfully..................");
            jLabel5.setText("");
            jLabel9.setText("");
            jLabel11.setText("");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteWorkingdayActionPerformed

    private void cbBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBatchActionPerformed

        populateWorkingDaysValues();
        populateTable();

// TODO add your handling code here:
    }//GEN-LAST:event_cbBatchActionPerformed

    private void btnViewAddWorkdaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAddWorkdaysActionPerformed
        // TODO add your handling code here:
       
        
        WorkingDaysInsert workingDaysInsert = new WorkingDaysInsert();
        workingDaysInsert.setVisible(true);
        workingDaysInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
       
    }//GEN-LAST:event_btnViewAddWorkdaysActionPerformed

    private void btnTimeSlotAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeSlotAddActionPerformed
        // TODO add your handling code here:
         TimeSlotInsert timeSlotInsert = new TimeSlotInsert();
        timeSlotInsert.setVisible(true);
        timeSlotInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_btnTimeSlotAddActionPerformed

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
            java.util.logging.Logger.getLogger(WorkingDaysView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkingDaysView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkingDaysView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkingDaysView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkingDaysView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteTimeSlot;
    private javax.swing.JButton btnDeleteWorkingday;
    private javax.swing.JButton btnTimeSlotAdd;
    private javax.swing.JButton btnViewAddWorkdays;
    private javax.swing.JComboBox cbBatch;
    private javax.swing.JComboBox cbTimeSlot;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
