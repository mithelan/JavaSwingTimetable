/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import com.mysql.jdbc.PreparedStatement;
import java.awt.TextArea;
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
        tagData1();
       
       
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
         
            row[1] = list.get(i).gettag();
            row[2] = list.get(i).getstudentGroup();
            row[3] = list.get(i).getsubject();
            row[4] = list.get(i).getno_of_students();
            row[5] = list.get(i).getsubgroup();
            row[6] = list.get(i).getsessionDuration();

            model.addRow(row);
            sessionTable.setRowHeight(1, 15);

        }

    }
    
    
     public ArrayList<LectureOnly> LList() {
        ArrayList<LectureOnly> LList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");

            String query = "select firstname,lastname from lecturernew";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            LectureOnly user;

            while (rs.next()) {
                user = new LectureOnly(
                             
                        rs.getString("firstname"),
                        rs.getString("lastname")
                       
                );

                LList.add(user);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return LList;

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
            String selectQuery = "select grpidg from grpidgen";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                groupidCombo.addItem(rs.getString("grpidg"));
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
            String selectQuery = "select subgrpidg from subgrpidgen";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                sgroupCombo.addItem(rs.getString("subgrpidg"));
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
    
     public void tagData1() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
            Statement st = conn.createStatement();
            String selectQuery = "select tag from tags";
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next()) {
                searchTag.addItem(rs.getString("tag"));
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        lectureCount = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        lecCombo3 = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchTag = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        searchLectu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lecCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        lecCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecCombo1ActionPerformed(evt);
            }
        });

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
                "Lecturers", "Tag", "Student Group", "Subject", "Students Number", "Sub grp", "Session Duration"
            }
        ));
        sessionTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(sessionTable);
        sessionTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (sessionTable.getColumnModel().getColumnCount() > 0) {
            sessionTable.getColumnModel().getColumn(0).setMinWidth(500);
            sessionTable.getColumnModel().getColumn(0).setPreferredWidth(500);
            sessionTable.getColumnModel().getColumn(0).setMaxWidth(500);
            sessionTable.getColumnModel().getColumn(1).setMinWidth(75);
            sessionTable.getColumnModel().getColumn(1).setPreferredWidth(75);
            sessionTable.getColumnModel().getColumn(1).setMaxWidth(75);
            sessionTable.getColumnModel().getColumn(2).setMinWidth(75);
            sessionTable.getColumnModel().getColumn(2).setPreferredWidth(75);
            sessionTable.getColumnModel().getColumn(2).setMaxWidth(75);
            sessionTable.getColumnModel().getColumn(3).setMinWidth(75);
            sessionTable.getColumnModel().getColumn(3).setPreferredWidth(75);
            sessionTable.getColumnModel().getColumn(3).setMaxWidth(75);
            sessionTable.getColumnModel().getColumn(4).setMinWidth(75);
            sessionTable.getColumnModel().getColumn(4).setPreferredWidth(75);
            sessionTable.getColumnModel().getColumn(4).setMaxWidth(75);
        }

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

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        searchTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTagActionPerformed(evt);
            }
        });

        jLabel10.setText("Sort By:");

        jLabel11.setText("Group ID :");

        searchLectu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLectuActionPerformed(evt);
            }
        });
        searchLectu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchLectuKeyReleased(evt);
            }
        });

        jLabel12.setText("Search :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lecCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lecCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lecCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(lectureCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numberStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tagCombo, 0, 117, Short.MAX_VALUE)
                                                    .addComponent(groupidCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(sgroupCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(124, 124, 124))
                                            .addComponent(lecCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchLectu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(277, 277, 277)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(searchTag, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(373, 373, 373)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(addRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lectureCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
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
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(numberStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(searchLectu)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
            String TotalLec=lectureValue1+","+lectureValue2+","+lectureValue3+","+lectureValue4;
            String tagValue = tagCombo.getSelectedItem().toString();
            String studentGroupValue = groupidCombo.getSelectedItem().toString();
            String subjectValue = subjectCombo.getSelectedItem().toString();
            String subGroupValue = sgroupCombo.getSelectedItem().toString();
            

            String GenerateSession=lectureValue1 +"\n"+lectureValue2+lectureValue3+lectureValue4+"\n"+subjectValue+"\n"+tagValue+"\n"+studentGroupValue+"."+subGroupValue+numberStudents.getText()+"("+sessionValue+")";
            String sql = "INSERT INTO session(lecturer1,tag,studentGroup,subject,no_of_students,subgroup,sessionDuration,sessionTot)  VALUES('" + TotalLec + "','" + tagValue + "','" + studentGroupValue + "','" + subjectValue + "','" + numberStudents.getText() + "' ,'" + subGroupValue + "' ,'" + sessionValue+ "' ,'"+GenerateSession+"'  )";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Added Sucessfully");
            DefaultTableModel model = (DefaultTableModel) sessionTable.getModel();
            model.setRowCount(0);

            show_user();
        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_addRecordActionPerformed

    private void subjectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboActionPerformed

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

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        
           try {
            String search_word = searchField.getText();
            System.out.println(search_word);
            int word_length = search_word.length();
            if(word_length > 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session where studentGroup LIKE '"+search_word+"%' ";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
                
             
            }else{
                  System.out.println("Yes this is workinh");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
               
                
            } 

            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTagActionPerformed
        // TODO add your handling code here:
        
           try {
             String tagValue = searchTag.getSelectedItem().toString();
            System.out.println(tagValue);
            int word_length = tagValue.length();
        
            
            
            if(tagValue=="All"){
               
                  Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session ";
              
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);
                  while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
            }else
            if(word_length > 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session where tag= '"+tagValue+ "' ";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
                
             
            }else {
                  System.out.println("Yes this is workinh");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
               
                
            } 

            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_searchTagActionPerformed

    private void searchLectuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLectuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchLectuActionPerformed

    private void searchLectuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchLectuKeyReleased
       
            try {
            String search_word = searchLectu.getText();
            System.out.println(search_word);
            int word_length = search_word.length();
            if(word_length > 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session where lecturer1 LIKE '%"+search_word+"%' ";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                 while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
                
               
            } else {
                System.out.println("Yes this is workinh");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
                String sql = "SELECT * FROM session";
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel building_table = (DefaultTableModel) sessionTable.getModel();
                building_table.setRowCount(0);

                  while(rs.next())
                {
                    Object o[] = {rs.getString("lecturer1")
                    , rs.getString("tag"), rs.getString("studentGroup")
                            , rs.getString("subject"), rs.getString("no_of_students")
                            , rs.getString("subgroup"), rs.getString("sessionDuration")
                    };
                    building_table.addRow(o);
                }
                
               
                
            }
//            buildings_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchLectuKeyReleased

    private void lecCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecCombo1ActionPerformed

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> groupidCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JComboBox<String> lecCombo1;
    private javax.swing.JComboBox<String> lecCombo2;
    private javax.swing.JComboBox<String> lecCombo3;
    private javax.swing.JComboBox<String> lecCombo4;
    private javax.swing.JComboBox<String> lectureCount;
    private javax.swing.JTextField numberStudents;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField searchLectu;
    private javax.swing.JComboBox<String> searchTag;
    private javax.swing.JComboBox<String> session;
    private javax.swing.JTable sessionTable;
    private javax.swing.JComboBox<String> sgroupCombo;
    private javax.swing.JComboBox<String> subjectCombo;
    private javax.swing.JComboBox<String> tagCombo;
    // End of variables declaration//GEN-END:variables
}
