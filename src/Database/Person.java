/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dolrich
 */
public class Person {
    public String name;
    public String address;
    public String ph;
    
    
    public Person(String name, String address, String ph){
        this.name = name;
        this.address = address;
        this.ph = ph;
       
        System.out.println("HELLO");
    }
    
    public void insertPerson(Connection con) throws SQLException{
        String sql = "insert into person values(null,?,?,?);";
           
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.address);
        ps.setString(3, this.ph);
        ps.executeUpdate();
        ps.close();           
        
    }
    
}
