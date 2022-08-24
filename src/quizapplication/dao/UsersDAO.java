/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quizapplication.dbutil.QuizApplicationDBConnection;
import quizapplication.pojo.User;
import quizapplication.pojo.UserProfile;

/**
 *
 * @author HP
 */
public class UsersDAO {

    public static boolean userLogin(User user) throws SQLException
    {
       Connection conn=QuizApplicationDBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select * from users where USERID=? and PASSWORD=? and USERTYPE=?");
       ps.setString(1, user.getUserName());
       ps.setString(2, user.getPassword());
       ps.setString(3, user.getUserType());
       System.out.println(user.getUserName()+" "+user.getPassword()+" "+user.getUserType().toLowerCase());
       ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("rohit");
            return true;
        }
        else
        {
            return false;
        }
    
    }
        public static boolean aadUser(User u)throws SQLException{
        Connection conn=QuizApplicationDBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
        ps.setString(1, u.getUserName());
        ResultSet rs=ps.executeQuery();
        if(!rs.next()){
        ps=conn.prepareStatement("insert into Users values(?,?,?)");
        ps.setString(1, u.getUserName());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getUserType());
        ps.executeUpdate();
        return true;
        }
        else{
            return false;
        }
    }
         public static boolean updatePassword(User user) throws SQLException
    {
       Connection conn=QuizApplicationDBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update users set password=? where USERID=?and USERTYPE=?");
       ps.setString(1, user.getPassword());
       ps.setString(2, user.getUserName());
       ps.setString(3, user.getUserType());
       System.out.println(user.getUserName()+" "+user.getPassword()+" "+user.getUserType());
       int ans=ps.executeUpdate();
        if(ans==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }

}
