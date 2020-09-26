/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class AddSession extends javax.swing.JFrame {

    /**
     * Creates new form AddSession
     */
    public AddSession() {

        initComponents();
        tagData();
        subjectData();
        subGroupData();
        studentGroupData();
        LectureData();
        show_user();
        StateChange();
    }

    public ArrayList<Session> GList() {
        ArrayList<Session> GList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");

            String query = "select * from session";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            Session user;

            while (rs.next()) {
                user = new Session(
                        rs.getString("lecturer1"),
                        rs.getString("lecturer2"),
                        rs.getString("lecturer3"),
                        rs.getString("lecturer4"),
                        rs.getString("tag"),
                        rs.getString("studentGroup"),
                        rs.getString("subject"),
                        rs.getString("no_of_students"),
                        rs.getString("subgroup"),
                        rs.getString("sessionDuration")
                );

                GList.add(user);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return GList;

    }

    public void show_user() {
        ArrayList<Session> list = GList();

        DefaultTableModel model = (DefaultTableModel) sessionTable.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getlecturer1();
            row[1] = list.get(i).getlecturer2();
            row[2] = list.get(i).getlecturer3();
            row[3] = list.get(i).getlecturer4();
            row[4] = list.get(i).gettag();
            row[5] = list.get(i).getstudentGroup();
            row[6] = list.get(i).getsubject();
            row[7] = list.get(i).getno_of_students();
            row[8] = list.get(i).getsubgroup();
            row[9] = list.get(i).getsessionDuration();

            model.addRow(row);
            sessionTable.setRowHeight(1, 15);

        }

    }

    public void LectureData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select firstname,lastname from lecturernew";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                String firstname = (rs.getString("firstname"));
                String lastname = (rs.getString("lastname"));
                String fullname = firstname + " " + lastname;
                lecCombo1.addItem(fullname);
                lecCombo2.addItem(fullname);
                lecCombo3.addItem(fullname);
                lecCombo4.addItem(fullname);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void studentGroupData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select groupid from groupid";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                groupidCombo.addItem(rs.getString("groupid"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void subGroupData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select subgrpid from subgroup";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                sgroupCombo.addItem(rs.getString("subgrpid"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tagData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select tag from tags";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                tagCombo.addItem(rs.getString("tag"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void subjectData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select sname,scode from subjectnew";
            ResultSet rs = st.executeQuery(selectQuery);

            while (rs.next()) {
                subjectCombo.addItem((rs.getString("sname") + "" + "(" + rs.getString("scode")) + ")");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lecCombo1 = new javax.swing.JComboBox<>();
        lecCombo2 = new javax.swing.JComboBox<>();
        lecCombo4 = new javax.swing.JComboBox<>();
        tagCombo = new javax.swing.JComboBox<>();
        groupidCombo = new javax.swing.JComboBox<>();
        numberStudents = new javax.swing.JTextField();
        sgroupCombo = new javax.swing.JComboBox<>();
        session = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subjectCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addRecord = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sessionTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        btn = new java.awt.Button();
        jLabel10 = new javax.swing.JLabel();
        lectureCount = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        lecCombo3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lecCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        lecCombo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        lecCombo4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        lecCombo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecCombo4ActionPerformed(evt);
            }
        });

        tagCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        tagCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tagComboItemStateChanged(evt);
            }
        });
        tagCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagComboActionPerformed(evt);
            }
        });

        groupidCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        groupidCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupidComboActionPerformed(evt);
            }
        });

        numberStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberStudentsActionPerformed(evt);
            }
        });

        sgroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        sgroupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sgroupComboActionPerformed(evt);
            }
        });

        session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3" }));
        session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Lecturers :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tag :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Student Group :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Subject");

        subjectCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        subjectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("No of Students :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Sub Group :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Session Duration :");

        addRecord.setText("Add Record");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(61, 42, 121));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("TIME TABLE SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel8)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel9.setText("Add Sessions");

        sessionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecture 1", "Lecture 2", "Lecture 3", "Lecture 4", "Tag", "Student Group", "Subject", "Students Number", "Sub grp", "Session Duration"
            }
        ));
        sessionTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(sessionTable);
        sessionTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btn.setActionCommand("Generate");
        btn.setLabel("Generate");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        lectureCount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        lectureCount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lectureCountItemStateChanged(evt);
            }
        });
        lectureCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectureCountActionPerformed(evt);
            }
        });

        label1.setName("lec"); // NOI18N
        label1.setText("Number of Lecturers");

        lecCombo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(419, 431, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(505, 505, 505))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(lecCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lecCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lecCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lecCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(sgroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(groupidCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(tagCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(124, 124, 124))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(lectureCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(13, 13, 13)
                                                        .addComponent(jLabel5)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(numberStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(addRecord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(441, 441, 441)
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lectureCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lecCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lecCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lecCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lecCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tagCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(sgroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupidCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(numberStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberStudentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberStudentsActionPerformed

    private void sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionActionPerformed

    private void lecCombo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecCombo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecCombo4ActionPerformed

    private void tagComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagComboActionPerformed

        String tagValue = tagCombo.getSelectedItem().toString();
        System.out.println(tagValue);
        String tute = "Tutorial";
        String lec = "Lecture";
        String prac = "Lab";

        if (tagValue.equals(lec)) {
            sgroupCombo.setVisible(false);
            jLabel6.setVisible(false);
            groupidCombo.setVisible(true);
            jLabel3.setVisible(true);

        } else if (tagValue.equals(tute)) {
            sgroupCombo.setVisible(false);
            jLabel6.setVisible(false);
             groupidCombo.setVisible(true);
            jLabel3.setVisible(true);
        } else if (tagValue.equals(prac)) {
            groupidCombo.setVisible(false);
            jLabel3.setVisible(false);
               sgroupCombo.setVisible(true);
            jLabel6.setVisible(true);
        } else {
            System.out.println("Select One");
        }


    }//GEN-LAST:event_tagComboActionPerformed

    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");

            String sessionValue = session.getSelectedItem().toString();
            String lectureValue1 = lecCombo1.getSelectedItem().toString();
            String lectureValue2 = lecCombo2.getSelectedItem().toString();
            String lectureValue3 = lecCombo3.getSelectedItem().toString();
            String lectureValue4 = lecCombo4.getSelectedItem().toString();
            String tagValue = tagCombo.getSelectedItem().toString();
            String studentGroupValue = groupidCombo.getSelectedItem().toString();
            String subjectValue = subjectCombo.getSelectedItem().toString();
            String subGroupValue = sgroupCombo.getSelectedItem().toString();

            //String GenerateSession=lectureValue1 +"\n"+lectureValue2+lectureValue3+lectureValue4+"\n"+subjectValue+"\n"+tagValue+"\n"+studentGroupValue+"."+subGroupValue+numberStudents.getText()+"("+sessionValue+")";
            String sql = "INSERT INTO session(lecturer1,lecturer2,lecturer3,lecturer4,tag,studentGroup,subject,no_of_students,subgroup,sessionDuration)  VALUES('" + lectureValue1 + "','" + lectureValue2 + "','" + lectureValue3 + "','" + lectureValue4 + "','" + tagValue + "','" + studentGroupValue + "','" + subjectValue + "','" + numberStudents.getText() + "' ,'" + subGroupValue + "' ,'" + sessionValue + "'  )";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Added Sucessfully");
            DefaultTableModel model = (DefaultTableModel) sessionTable.getModel();
            model.setRowCount(0);

            show_user();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_addRecordActionPerformed

    private void subjectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");

            String sessionValue = session.getSelectedItem().toString();
            String lectureValue1 = lecCombo1.getSelectedItem().toString();
            String lectureValue2 = lecCombo2.getSelectedItem().toString();
            String lectureValue3 = lecCombo3.getSelectedItem().toString();
            String lectureValue4 = lecCombo4.getSelectedItem().toString();
            String tagValue = tagCombo.getSelectedItem().toString();
            String studentGroupValue = groupidCombo.getSelectedItem().toString();
            String subjectValue = subjectCombo.getSelectedItem().toString();
            String subGroupValue = sgroupCombo.getSelectedItem().toString();

            String GenerateSession = lectureValue1 + "\n" + lectureValue2 + lectureValue3 + lectureValue4 + "\n" + subjectValue + "\n" + tagValue + "\n" + studentGroupValue + "." + subGroupValue + numberStudents.getText() + "(" + sessionValue + ")";
            String sql = "INSERT INTO newsession(GenerateSession) VALUES('" + GenerateSession + "' )";

            Statement st = conn.createStatement();
            st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Generated");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnActionPerformed

    private void sgroupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sgroupComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sgroupComboActionPerformed

    private void tagComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tagComboItemStateChanged
        // TODO add your handling code here:

        StateChange();


    }//GEN-LAST:event_tagComboItemStateChanged

    private void lectureCountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lectureCountItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lectureCountItemStateChanged

    private void lectureCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectureCountActionPerformed
        // TODO add your handling code here:
          String count = lectureCount.getSelectedItem().toString();
        System.out.println(count);
   

        if (count=="1") {
            lecCombo1.setVisible(true);
            lecCombo2.setVisible(false);
             lecCombo3.setVisible(false);
             lecCombo4.setVisible(false);
        }else if (count=="2") {
            lecCombo1.setVisible(true);
            lecCombo2.setVisible(true);
             lecCombo3.setVisible(false);
             lecCombo4.setVisible(false);
           
        }else if (count=="3") {
            lecCombo1.setVisible(true);
            lecCombo2.setVisible(true);
             lecCombo3.setVisible(true);
             lecCombo4.setVisible(false);
            
        }else if (count=="4") {
            lecCombo1.setVisible(true);
            lecCombo2.setVisible(true);
             lecCombo3.setVisible(true);
             lecCombo4.setVisible(true);
        }
    }//GEN-LAST:event_lectureCountActionPerformed

    private void groupidComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupidComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupidComboActionPerformed

    private void StateChange() {
        lecCombo1.setVisible(true);
        lecCombo2.setVisible(false);
         lecCombo3.setVisible(false);
        lecCombo4.setVisible(false);


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
            java.util.logging.Logger.getLogger(AddSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecord;
    private java.awt.Button btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> groupidCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JComboBox<String> lecCombo1;
    private javax.swing.JComboBox<String> lecCombo2;
    private javax.swing.JComboBox<String> lecCombo3;
    private javax.swing.JComboBox<String> lecCombo4;
    private javax.swing.JComboBox<String> lectureCount;
    private javax.swing.JTextField numberStudents;
    private javax.swing.JComboBox<String> session;
    private javax.swing.JTable sessionTable;
    private javax.swing.JComboBox<String> sgroupCombo;
    private javax.swing.JComboBox<String> subjectCombo;
    private javax.swing.JComboBox<String> tagCombo;
    // End of variables declaration//GEN-END:variables
}
