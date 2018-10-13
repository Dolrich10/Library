/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dolrich
 */
public class Database {
    

    Connection con;
    String password = "asd";
    String uri = "jdbc:mysql://localhost:3306/lib";
    String user = "root";
    
    public Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(uri, user, password);
        return con;
    }
    
    public void closeConnection() throws SQLException{
    	con.close();
    }

}
