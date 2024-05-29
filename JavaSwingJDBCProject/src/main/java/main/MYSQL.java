/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class MYSQL {
    static String host="localhost";
    static String port="3306";
    static String username="root";
    static String pw="1234";
    static String db="swing_db";
    
    static Connection con;
    
    public static void getConnection() throws Exception{
        String url="jdbc:mysql://"+host+":"+port+"/"+db;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(url, username, pw);
        
    }
    
    //to insert,update,delete
    public static void sendQuery(String query) throws Exception{
        if(con==null){
            getConnection();
        }
        Statement s=con.createStatement();
        s.executeUpdate(query);
    }
     
    //select 
    public static ResultSet getData(String query) throws Exception{
        if(con==null){
            getConnection();
        }
        Statement s=con.createStatement();
        return s.executeQuery(query);
    }
    
}
