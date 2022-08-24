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
import java.sql.Statement;
import java.util.ArrayList;
import quizapplication.dbutil.QuizApplicationDBConnection;
import quizapplication.pojo.Exam;

/**
 *
 * @author HP
 */
public class ExamDAO {
    
   public static String getExamId() throws SQLException
   {
       Connection conn=QuizApplicationDBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select count(*) as count from exam");
       int rowCount=0;
       if(rs.next())
        rowCount=rs.getInt(1);
       String newId="EX-"+(rowCount+1);
       return newId;
   }
   public static void addExam(Exam newExam) throws SQLException
   {
       Connection conn=QuizApplicationDBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert  into exam values(?,?,?)");
       ps.setString(1,newExam.getExamId());
       ps.setString(2,newExam.getLanguage());
       ps.setString(3, newExam.getQuestionNumber()+"");
       ps.executeUpdate();   
   }
   public static ArrayList<String> getExamIdBySubject(String Subject) throws SQLException
   {
       Connection conn=QuizApplicationDBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select examId from exam where language=?");
       ps.setString(1, Subject);
       ResultSet rs=ps.executeQuery();
       
       ArrayList<String> examIdList=new ArrayList();
      while(rs.next())
      {
          System.out.println("rohit");
       examIdList.add(rs.getString(1));
       System.out.println(rs.getString(1));
      }
       System.out.println(examIdList);
      return examIdList;
   }
 
   public static int getQuestionCountByExam(String examId) throws SQLException
   {
       Connection conn=QuizApplicationDBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select Total_Question  from exam where examId=(?)");
       ps.setString(1, examId);
       ResultSet rs=ps.executeQuery();
       rs.next();
      int questionCount=rs.getInt(1);
      return questionCount;
   }
}
