/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagechat;

import encryption.Encryption;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;

/**
 *
 * @author SHABAAN
 */
public class MessagesDisplay1 extends javax.swing.JFrame {

    public String send;

    /**
     * Creates new form MessagesDisplay
     */
    public MessagesDisplay1() {

        initComponents();
    }

    public String getNewValue() {
        return this.send;
    }

    public String getMess(String s) {
        System.out.println("AA" + s);
        this.send = s;
        return s;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        northPanel = new javax.swing.JPanel();
        scrollPaneNorth = new javax.swing.JScrollPane();
        textAreaNorth = new javax.swing.JTextArea();
        centerPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        scrollPaneCenter = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCenter = new javax.swing.JTextArea();
        comboBoxName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPaneNorth.setMinimumSize(new java.awt.Dimension(100, 327));
        scrollPaneNorth.setPreferredSize(new java.awt.Dimension(100, 327));

        textAreaNorth.setEditable(false);
        textAreaNorth.setColumns(20);
        textAreaNorth.setRows(5);
        scrollPaneNorth.setViewportView(textAreaNorth);

        javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
        northPanel.setLayout(northPanelLayout);
        northPanelLayout.setHorizontalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneNorth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        northPanelLayout.setVerticalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneNorth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textAreaCenter.setColumns(20);
        textAreaCenter.setRows(5);
        jScrollPane1.setViewportView(textAreaCenter);

        scrollPaneCenter.setViewportView(jScrollPane1);

        comboBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(northPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(northPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        sendMessages();
        getMessage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNameActionPerformed
        if ("Robert".equals(comboBoxName.getSelectedItem().toString())) {
            getMessage();
        } else if ("Evans".equals(comboBoxName.getSelectedItem().toString())) {
            getMessage1();
        }

    }//GEN-LAST:event_comboBoxNameActionPerformed

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
            java.util.logging.Logger.getLogger(MessagesDisplay1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessagesDisplay1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessagesDisplay1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessagesDisplay1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessagesDisplay1().setVisible(true);

                File file = new File("src/database/MessageChat.db.cr");

                if (file.renameTo(new File("src/database/MessageChat.db"))) {
                    // if file copied successfully then delete the original file 
                    file.delete();
                    System.out.println("File moved successfully");
                    Login.connect();
                } else {
                    System.out.println("Failed to move the file");
                }

                comboBox();
                textAreaCenter.setFocusable(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private static javax.swing.JComboBox<String> comboBoxName;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel northPanel;
    private javax.swing.JScrollPane scrollPaneCenter;
    private javax.swing.JScrollPane scrollPaneNorth;
    private static javax.swing.JTextArea textAreaCenter;
    private static javax.swing.JTextArea textAreaNorth;
    // End of variables declaration//GEN-END:variables

    public static void getMessage1() {

        String message;

        String sql = "SELECT * FROM messages WHERE name_user = 'Evans'";
        String url = "jdbc:sqlite:src/database/MessageChat.db";
        Connection con = null;
        ResultSet rs = null;
        Statement stm = null;

        try {
            con = DriverManager.getConnection(url);
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            System.out.println("Query executed");

            //loop through the result set
            while (rs.next()) {
                String sendIn = rs.getString("message");
                textAreaNorth.append(sendIn + "\n");
                System.out.println(sendIn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void getMessage() {

        String publicKey = "hdhdhhydobafhu%^";
        File inputFile = new File("src/database/MessageChat.db");
        File encrptedFile = new File("src/database/MessageChat.db.enc");
        File dencrptedFile = new File("src/database/MessageChat.db");

        Encryption encryption = new Encryption();
        encryption.encryption(Cipher.DECRYPT_MODE, publicKey, encrptedFile, dencrptedFile);
        encrptedFile.delete();
        System.out.println("File delete successfully");
        
        String message;

        String sql = "SELECT * FROM messages WHERE name_user = 'Robert'";
        String url = "jdbc:sqlite:src/database/MessageChat.db";
        Connection con = null;
        ResultSet rs = null;
        Statement stm = null;

        try {
            con = DriverManager.getConnection(url);
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            System.out.println("Query executed");

            //loop through the result set
            while (rs.next()) {
                String sendIn = rs.getString("message");
                textAreaNorth.append(sendIn + "\n");
                System.out.println(sendIn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void comboBox() {
        String sql = "SELECT * FROM users";
        String url = "jdbc:sqlite:src/database/MessageChat.db";
        Connection con;
        ResultSet rs;
        Statement stm;

        try {
            con = DriverManager.getConnection(url);
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            //System.out.println("Query executed");

            //loop through the result set
            while (rs.next()) {
                String items = rs.getString("name_user");
                comboBoxName.addItem(items);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessages() {
        //String display = textAreaNorth.setText(t);
        //String name = txtName.getText();
        //char[] pass = txtPassword.getPassword();

        String sendIn = textAreaCenter.getText();
        String combo = comboBoxName.getSelectedItem().toString();
        System.out.println(combo);

        if (null == combo) {
            System.out.println("Wrong Sender");
        } else {
            switch (combo) {
                case "Robert": {
                    String sql = "INSERT INTO messages (message,name_user) VALUES(?,?)";
                    String url = "jdbc:sqlite:src/database/MessageChat.db";
                    Connection con = null;
                    PreparedStatement stm = null;
                    try {
                        con = DriverManager.getConnection(url);
                        stm = con.prepareStatement(sql);
                        stm.setString(1, combo + ":" + sendIn);
                        stm.setString(2, "Robert");

                        stm.executeUpdate();
                        System.out.println("Data Inserted Successfully");

                        //String text1 = newText.text;
                        //System.out.println(text1);
                        getMess(sendIn);
                        //new MessagesDisplay2().setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            stm.close();
                            con.close();

                            String publicKey = "hdhdhhydobafhu%^";
                            File inputFile = new File("src/database/MessageChat.db");
                            File encrptedFile = new File("src/database/MessageChat.db.enc");
                            File dencrptedFile = new File("src/database/MessageChat.db");

                            Encryption encryption = new Encryption();
                            encryption.encryption(Cipher.ENCRYPT_MODE, publicKey, inputFile, encrptedFile);
                            inputFile.delete();
                            System.out.println("File delete successfully");

                            //encryption.encryption(Cipher.DECRYPT_MODE, publicKey, encrptedFile, dencrptedFile);
                        } catch (SQLException ex) {
                            Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
                case "Evans": {
                    String sql = "INSERT INTO messages (message,name_user) VALUES(?,?)";
                    String url = "jdbc:sqlite:src/database/MessageChat.db";
                    Connection con = null;
                    PreparedStatement stm = null;
                    try {
                        con = DriverManager.getConnection(url);
                        stm = con.prepareStatement(sql);
                        stm.setString(1, combo + ":" + sendIn);
                        stm.setString(2, "Evans");

                        stm.executeUpdate();
                        System.out.println("Data Inserted Successfully");

                        //String text1 = newText.text;
                        //System.out.println(text1);
                        getMess(sendIn);
                        //new MessagesDisplay2().setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            stm.close();
                            con.close();

                            String publicKey = "hdhdhhydobafhu%^";
                            File inputFile = new File("src/database/MessageChat.db");
                            File encrptedFile = new File("src/database/MessageChat.db.enc");
                            File dencrptedFile = new File("src/database/MessageChat.db");

                            Encryption encryption = new Encryption();
                            encryption.encryption(Cipher.ENCRYPT_MODE, publicKey, inputFile, encrptedFile);
                            inputFile.delete();
                            System.out.println("File delete successfully");

                            //encryption.encryption(Cipher.DECRYPT_MODE, publicKey, encrptedFile, dencrptedFile);
                        } catch (SQLException ex) {
                            Logger.getLogger(MessagesDisplay1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Wrong Sender");
                    break;
            }
        }

    }
}
