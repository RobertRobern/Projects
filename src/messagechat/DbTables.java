/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagechat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHABAAN
 */
public class DbTables {
    
            
    public static void createMessageTable() {

        //SQLite connection String
        String url = "jdbc:sqlite:src/database/MessageChat.db";

        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS messages (\n"
                + " message_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " message text,\n"
                + " name_user text"
                + " REFERENCES users(name_user)"
                + "\n);";

        try {

            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            //create a new table
            stmt.execute(sql);
            System.out.println("Message Table created");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createUserTable() {

        //SQLite connection String
        String url = "jdbc:sqlite:src/database/MessageChat.db";

        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " user_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " name_user text UNIQUE,\n"
                + " email text NOT NULL,\n"
                + " pass text NOT NULL"                
                + "\n);";

        try {

            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            //create a new table
            stmt.execute(sql);
            System.out.println("User Table created");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        
        createMessageTable();
        createUserTable();
    }
}
