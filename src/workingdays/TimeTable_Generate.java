/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workingdays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M.ANJANAN
 */
public class TimeTable_Generate extends javax.swing.JFrame {

    /**
     * Creates new form TimeTable_Generate
     */
    public TimeTable_Generate() {
        initComponents();
        populateStudentGroup();
        populateBatch();
        populateTimeTable();
        comboSession.removeAllItems();
              


    }

    public void populateTimeTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

          Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM timetable where student_subgroup='" + comboStudentGroup.getSelectedItem().toString() + "'");
            timeTable.setModel(buildTableModel(rs));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void populateRoom() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

           Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            String query = "select * from rooms";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String data = rs.getString("room_name");

                comboRoom.addItem(new ComboItem(data, data));

            }

        } catch (Exception e) {

            System.out.println("e");
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

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

    public void populateSession() {
        comboSession.removeAllItems();
        try {
            Class.forName("com.mysql.jdbc.Driver");

         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
            String grp = comboStudentGroup.getSelectedItem().toString();
            System.out.println(grp);
            grp = grp.replaceAll("\\s", "");
            ResultSet rs = statement.executeQuery("SELECT * FROM session where subgroup=\"" + "1.1.IT.COPY_PASTE.1" + "\"");
            System.out.println(rs);
            while (rs.next()) {
                String data = "xddg";
                data = rs.getString("sessionTot");
                System.out.println(data);

                comboSession.addItem(new ComboItem(data, data));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
        }
        populateRoom();
    }

    public void populateStudentGroup() {
        comboSession.removeAll();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM subgrpidgen");

            while (rs.next()) {
                String data;
                data = rs.getString("subgrpidg");

                comboStudentGroup.addItem(new ComboItem(data, data));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(TimeSlotInsert.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void populateDays() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

           Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
            
            String query = "select days from workingdays where batch ='" + comboBatch.getSelectedItem().toString() + "'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                comboDay.removeAllItems();

                String data2 = rs.getString(1);
                String[] daysArray = data2.split(",");
                for (int i = 0; i < daysArray.length; i++) {
                    comboDay.addItem(new ComboItem(daysArray[i], daysArray[i]));

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void populateBatch() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            String query = "select batch,days from workingdays";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                comboDay.removeAllItems();  
                String data = rs.getString(1);
                String data2 = rs.getString(2);
                String[] daysArray = data2.split(",");
                for (int i = 0; i < daysArray.length; i++) {
                    comboDay.addItem(new ComboItem(daysArray[i], daysArray[i]));

                }
                comboBatch.addItem(new ComboItem(data, data));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void populateTimeSlot() {
        comboTimeSlot.removeAllItems();
        try {
            Class.forName("com.mysql.jdbc.Driver");

Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
            String query = "select type,start_time from timeslots where batch = '" + comboBatch.getSelectedItem().toString() + "'";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String data = rs.getString(1);
                String data1 = rs.getString(2);
                int duration = Integer.valueOf(data);

                String[] timeSplit = data1.split(":");
                int hh = Integer.valueOf(timeSplit[0]);
                int mm = Integer.valueOf(timeSplit[1]);
                String comboboxvalue = data1 + "-";
                int total = hh * 60 + mm + duration;

                comboboxvalue = total / 60 < 10 ? comboboxvalue.concat("0" + total / 60 + ":") : comboboxvalue.concat(total / 60 + ":");
//              if(total/60<10){
//                comboboxvalue = comboboxvalue.concat("0"+ total/60+":");
//              }else  { comboboxvalue = comboboxvalue.concat(total/60+":");}
//              
                comboboxvalue = total % 60 < 10 ? comboboxvalue.concat("0" + total % 60) : comboboxvalue.concat("" + total % 60);
//              if(total%60<10){
//               comboboxvalue = comboboxvalue.concat("0"+total%60);
//              }else{
//                  comboboxvalue = comboboxvalue.concat(""+total%60);
//           
//              }

                comboTimeSlot.addItem(new ComboItem(comboboxvalue, comboboxvalue));
            }

        } catch (Exception e) {
            System.out.println(e);
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
        btnHome = new javax.swing.JButton();
        btnGenerateTimeTable = new javax.swing.JButton();
        btnViewTimetable = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboStudentGroup = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboSession = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboRoom = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        comboDay = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboTimeSlot = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeTable = new javax.swing.JTable();
        comboBatch = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("Generate Timetable");

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnGenerateTimeTable.setText("Generate Timetable");
        btnGenerateTimeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTimeTableActionPerformed(evt);
            }
        });

        btnViewTimetable.setText("View TimeTable");

        jLabel2.setText("Select Student Group");

        comboStudentGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStudentGroupActionPerformed(evt);
            }
        });

        jLabel3.setText("Session");

        jLabel4.setText("Room");

        comboRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRoomActionPerformed(evt);
            }
        });

        jLabel5.setText("Day");

        comboDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDayActionPerformed(evt);
            }
        });

        jLabel6.setText("TimeSlot");

        comboTimeSlot.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        timeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(timeTable);

        comboBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBatchActionPerformed(evt);
            }
        });

        jLabel7.setText("Batch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(comboRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAdd))
                    .addComponent(comboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnHome)
                        .addGap(275, 275, 275)
                        .addComponent(btnGenerateTimeTable)
                        .addGap(201, 201, 201)
                        .addComponent(btnViewTimetable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(comboStudentGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnGenerateTimeTable)
                    .addComponent(btnViewTimetable))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(comboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(comboStudentGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void comboStudentGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStudentGroupActionPerformed
        populateSession();          // TODO add your handling code here:


    }//GEN-LAST:event_comboStudentGroupActionPerformed

    private void comboRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRoomActionPerformed

    private void comboDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDayActionPerformed

    private void comboBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBatchActionPerformed
        populateDays();        // TODO add your handling code here:

        populateTimeSlot();
        populateTimeTable();


    }//GEN-LAST:event_comboBatchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");

         Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();

            String query = "insert into timetable(student_subgroup,session, room,batch,day,timeslot) values('" + comboStudentGroup.getSelectedItem().toString() + "','" + 
                    comboSession.getSelectedItem().toString() + "','" + comboRoom.getSelectedItem().toString() +
                    "','" + comboBatch.getSelectedItem().toString() + "','" + comboDay.getSelectedItem().toString() + "','" + 
                    comboTimeSlot.getSelectedItem().toString() + "')";
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnGenerateTimeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTimeTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerateTimeTableActionPerformed

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
            java.util.logging.Logger.getLogger(TimeTable_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeTable_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeTable_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeTable_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeTable_Generate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGenerateTimeTable;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnViewTimetable;
    private javax.swing.JComboBox comboBatch;
    private javax.swing.JComboBox comboDay;
    private javax.swing.JComboBox comboRoom;
    private javax.swing.JComboBox comboSession;
    private javax.swing.JComboBox comboStudentGroup;
    private javax.swing.JComboBox comboTimeSlot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable timeTable;
    // End of variables declaration//GEN-END:variables
}
