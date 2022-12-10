/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gui.Config;
import gui.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class Connect {

    static Connection connect;
    //create a method return value is Connection

    public static Connection getConnect() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=VehicleShowroomManagementSystem;", "sa", "");

        } catch (SQLException ex) {
            Properties pro = new Properties();
            File file = new File("config.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            pro.load(new FileInputStream(file));
            String host = pro.getProperty("host");
            String port = pro.getProperty("port");
            String database = pro.getProperty("database");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String typeConnect = pro.getProperty("typeConnect");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + database, user, password);
            } catch (Exception e) {
                Message.error("Connection failed!\nPlease re-configure connection server databse...");
                new Config(null, true);
            }
        }
        return conn;
    }

    public static void CloseConnection() {
        if (connect != null) {
            try {
                connect.close();
                connect = null;
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
