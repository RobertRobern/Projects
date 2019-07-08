/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHABAAN
 */
public class DbConnection {
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            //load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Create db connection
            con = DriverManager.getConnection("jbdc:sqlite:src/database/MessageChat.db");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return con;
    }
}
