/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class QuizApplicationDBConnection {
    
   private static Connection conn;
   
   static 
   {
       try
       {
        Class.forName("oracle.jdbc.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-68JUMAG:1521/xe","project","java");
        JOptionPane.showMessageDialog(null, "Driver Loaded Succecfully ", "Succes ", JOptionPane.INFORMATION_MESSAGE);
 
       }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(null, "Exception while loading or registering driver: "+e, "Exception ! ", JOptionPane.ERROR_MESSAGE);
       }
               
   }
    
   public static Connection getConnection()
   {
       return conn;
   }
   public static void closeConnection()
   {
       	if(conn!=null)
	{
	try
	{
		conn.close();
		System.out.println("conn close Succecfully");
	}
	catch(SQLException a)
    {
    System.out.println("problem in close the connection "+ a);
    }
	}
   }
}
