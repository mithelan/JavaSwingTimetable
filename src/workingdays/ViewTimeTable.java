/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workingdays;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import static workingdays.TimeTable_Generate.buildTableModel;

/**
 *
 * @author M.ANJANAN
 */
public class ViewTimeTable extends javax.swing.JFrame {

   
//    String db = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729";
//    String userName = "sql12367729";
//    String password = "zWmfRFXCpe";
    /**
     * Creates new form ViewTimeTable
     */
    public ViewTimeTable() {
        initComponents();
        populateRooms();
//      jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
//
//for (int column = 0; column < jTable1.getColumnCount(); column++)
//{
//    TableColumn tableColumn = jTable1.getColumnModel().getColumn(column);
//    int preferredWidth = tableColumn.getMinWidth();
//    int maxWidth = tableColumn.getMaxWidth();
//
//    for (int row = 0; row < jTable1.getRowCount(); row++)
//    {
//        TableCellRenderer cellRenderer = jTable1.getCellRenderer(row, column);
//        Component c = jTable1.prepareRenderer(cellRenderer, row, column);
//        int width = c.getPreferredSize().width + jTable1.getIntercellSpacing().width;
//        preferredWidth = Math.max(preferredWidth, width);
//
//        //  We've exceeded the maximum width, no need to check other rows
//
//        if (preferredWidth >= maxWidth)
//        {
//            preferredWidth = maxWidth;
//            break;
//        }
//    }
//
//    tableColumn.setPreferredWidth( preferredWidth );
//}

//  jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
      
        
       
//     container.j     populateStudentGroup();
       
     
    }
  public void populateLecturer(){
   jComboBox1.removeAllItems(); 
        String values = comboCategory.getSelectedItem().toString();
     
        System.out.println(values);
        try {
            Class.forName("com.mysql.jdbc.Driver"); 

            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
          
                String query = "select * from lecturernew";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String data;
                    data = rs.getString("firstname");
                    System.out.println(data);
                    jComboBox1.addItem(new ComboItem(data, data));

                }
 
            
          

        } catch (Exception e) {
            System.out.println();
        }}
    public void populateStudentGroup() {
         jComboBox1.removeAllItems(); 
        String values = comboCategory.getSelectedItem().toString();
     
        System.out.println(values);
        try {
            Class.forName("com.mysql.jdbc.Driver"); 

              Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
          
                String query = "select * from subgrpidgen";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String data;
                    data = rs.getString("subgrpidg");
                    System.out.println(data);
                    jComboBox1.addItem(new ComboItem(data, data));

                }
 
            
          

        } catch (Exception e) {
            System.out.println();
        }
        
    }
    
    
    
     public void populateRooms() {
         
      jComboBox1.removeAllItems();
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
 
             Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
            
                String query = "select * from rooms";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String data;
                    data = rs.getString("room_name");
                    jComboBox1.addItem(new ComboItem(data, data));               
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }

    }
      public void populateLectures() {
        
        
        String values = comboCategory.getSelectedItem().toString();
        System.out.println(values);
        try {
            Class.forName("com.mysql.jdbc.Driver");
 
              Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

            Statement statement = conn.createStatement();
            if (values=="Lecturer") {
                String query = " select * from session ";    
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String data;
                    data = rs.getString("lecturer1");
                    jComboBox1.addItem(new ComboItem(data, data));
                }

            }
            

        } catch (Exception e) {
            System.out.println();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboCategory = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("View Time Table");

        jLabel2.setText("Choose Category:");

        comboCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Room", "Studentgroup", "Lecturer" }));
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
 
        
  
    String values = comboCategory.getSelectedItem().toString();
        System.out.println(values);
       if(values ==null){
       
       }else if(values.equals("Room")){
   
      populateRooms();  
       }else if(values.equals("Studentgroup")){
         
         populateStudentGroup();
       
       }else if(values.equals("Lecturer")){
       populateLecturer();
       
       }  
       // TODO add your handling code here:
    
    //  populateLectures();
     //  populateStudentGroup();
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      // TODO add your handling code here:
        MyTableModel myt = new MyTableModel();
        myt.setValueAt("8.30", 0, 0);
        myt.setValueAt("9:00", 1, 0);
        myt.setValueAt("9.30", 2, 0);
        myt.setValueAt("10.00", 3, 0);
        myt.setValueAt("10.30", 4, 0);
        myt.setValueAt("11.30", 5, 0);
        myt.setValueAt("12.00", 6, 0);
        myt.setValueAt("12.30", 7, 0);
        myt.setValueAt("13.00", 8, 0);
        myt.setValueAt("13.30", 9, 0);
        myt.setValueAt("14.00", 10, 0);
        myt.setValueAt("14.30", 11, 0);
        myt.setValueAt("15.00", 12, 0);
        myt.setValueAt("15.30", 13, 0);
        myt.setValueAt("16.00", 14, 0);
        myt.setValueAt("16.30", 15, 0);
        myt.setValueAt("17.00", 16, 0);

        myt.setValueAt("17.30", 17, 0);
        myt.setValueAt("18.00", 18, 0);
        myt.setValueAt("18.30", 19, 0);

        jTable1.setModel(myt);
        // TODO add your handling code here:
         if(comboCategory.getSelectedItem().toString().equals("Room")){
          
            try {
                Class.forName("com.mysql.jdbc.Driver");
  Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

                Statement statement = conn.createStatement();

                String query = "select * from timetable where room ='"+jComboBox1.getSelectedItem().toString()+"'";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String session = rs.getString("session");
                    String day = rs.getString("day");
                    String timeslot = rs.getString("timeslot");
                    String[] splitedtimeslot  =timeslot.split("-");
                    // String[] splittedstarttime=splitedtimeslot[0].split(":");

                    System.out.println("spllitedtime slot"+splitedtimeslot[0]);
                    int column = getDayIndex(day);
                    int row = startTimeIndex(splitedtimeslot[0]);
                    myt.setValueAt(session, row, column);
                    System.out.println(column);
                    System.out.println(row);
                    int width = 0;
                    //tableMain.setModel(buildTableModel(rs));

                }

            } catch (Exception e) {
                System.out.println(e);
            }
             
        } else if(comboCategory.getSelectedItem().toString().equals("Studentgroup")){
          
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

                Statement statement = conn.createStatement();

                String query = "select * from timetable where student_subgroup ='"+jComboBox1.getSelectedItem().toString()+"'";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String session = rs.getString("session");
                    String day = rs.getString("day");
                    String timeslot = rs.getString("timeslot");
                    String[] splitedtimeslot  =timeslot.split("-");
                    // String[] splittedstarttime=splitedtimeslot[0].split(":");

                    System.out.println("spllitedtime slot"+splitedtimeslot[0]);
                    int column = getDayIndex(day);
                    int row = startTimeIndex(splitedtimeslot[0]);
                    myt.setValueAt(session, row, column);
                    System.out.println(column);
                    System.out.println(row);
                    int width = 0;
                    //tableMain.setModel(buildTableModel(rs));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }else if(comboCategory.getSelectedItem().toString().equals("Lecturer")){
          try {
                Class.forName("com.mysql.jdbc.Driver");

               Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

                Statement statement = conn.createStatement();

                String query = "select * from timetable where session like'%"+jComboBox1.getSelectedItem().toString()+"%'";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String session = rs.getString("session");
                    String day = rs.getString("day");
                    String timeslot = rs.getString("timeslot");
                    String[] splitedtimeslot  =timeslot.split("-");
                    // String[] splittedstarttime=splitedtimeslot[0].split(":");

                    System.out.println("spllitedtime slot"+splitedtimeslot[0]);
                    int column = getDayIndex(day);
                    int row = startTimeIndex(splitedtimeslot[0]);
                    myt.setValueAt(session, row, column);
                    System.out.println(column);
                    System.out.println(row);
                    int width = 0;
                    //tableMain.setModel(buildTableModel(rs));

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
 private void timeTableFormatter(){
     
     
     
     }
 private int getDayIndex(String day){
        if(day.equals("Monday")){
        return 1;
        }else if(day.equals("Tuesday")){
            return 2;
        }else if(day.equals("Wednesday")){
            return 3;
        }else if(day.equals("Thursday")){
           return 4; 
        }else if(day.equals("Friday")){
            return 5;
        }
        return 0;
 }
 
 private int startTimeIndex(String startTime){
      if(startTime.equals("08:30")){
          return 0;
      }else if (startTime.equals("09:00")){
           return 1;
      }else if (startTime.equals("09:30")){
           return 2;
      }else if (startTime.equals("10:30")){
           return 3;
      }else if (startTime.equals("11:00")){
           return 4;
      }else if (startTime.equals("11:30")){
           return 5;
      }else if (startTime.equals("12:00")){
           return 6;
      }else if (startTime.equals("12:30")){
           return 7;
      }else if (startTime.equals("13:00")){
           return 8;
      }else if (startTime.equals("13:30")){
           return 9;
      }else if (startTime.equals("14.00")){
           return 10;
      }else if (startTime.equals("14:30")){
           return 11;
      }else if (startTime.equals("15:00")){
           return 12;
      }else if (startTime.equals("15:30")){
           return 13;
      }else if (startTime.equals("16:00")){
           return 14;
      }else if (startTime.equals("16:30")){
           return 15;
      }else if (startTime.equals("17:00")){
           return 16;
      }else if (startTime.equals("17:30")){
           return 17;
      }else if(startTime.equals("18:00")){
      return 18;}
        
   return 0;    
     
     
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
            java.util.logging.Logger.getLogger(ViewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTimeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCategory;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
