/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sadia
 */
import java.sql.*;
import javax.swing.*;
public class ConnectDB {
    Connection conn=null;
    public static Connection ConnecrDb(){
        try{
           //Class.forName("org.sqlite.JDBC");
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/topu","root","");
          //  Connection conn= DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql25211","sql25211","qA7!rB1%");

            //JOptionPane.showMessageDialog(null, "Connection Established");
           
           return conn;

        }catch(Exception e){
            System.out.println("not found");
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }



}
