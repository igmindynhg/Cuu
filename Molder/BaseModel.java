/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AD
 */
public class BaseModel {
        protected Connection getConnBaseModel() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String urlDB = "jdbc:sqlserver://localhost:1433; databasename=QLCoffee; encrypt=false";
            String userName = "sa";
            String passwordUser = "duyeqqp";
            conn = DriverManager.getConnection(urlDB, userName, passwordUser);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return conn;
    }
}
