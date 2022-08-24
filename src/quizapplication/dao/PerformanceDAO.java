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
import quizapplication.pojo.Answer;
import quizapplication.pojo.AnswerStore;
import quizapplication.pojo.Exam;
import quizapplication.pojo.Performance;
import quizapplication.pojo.StudentScore;
import quizapplication.pojo.UserProfile;

/**
 *
 * @author HP
 */
public class PerformanceDAO {
    public static ArrayList<String> getAllStudentId() throws SQLException
    {
      Connection conn=QuizApplicationDBConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs=st.executeQuery("Select distinct userid from performance");
     ArrayList<String> examid=new ArrayList<>();
     while(rs.next())
     {
        examid.add(rs.getString(1));
     }
     return examid; 
    }
    public static ArrayList<String> getAllExamId(String userId) throws SQLException
    {
           Connection conn=QuizApplicationDBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");
          ps.setString(1,userId);
           ResultSet rs= ps.executeQuery();
    ArrayList<String> examid=new ArrayList<>();
     while(rs.next())
     {
        examid.add(rs.getString(1));
     }
     return examid; 
    }
    
    
    
    
     public static StudentScore getScore(String studentId,String examId)throws SQLException{
        Connection conn=QuizApplicationDBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select language,per from Performance where userid=? and examid=?");
        ps.setString(1, studentId);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        StudentScore studentScore=new StudentScore();
        rs.next();
        studentScore.setLanguage(rs.getString(1));
        studentScore.setPer(rs.getFloat(2));
        return studentScore;
    }
    
    public static ArrayList<Performance> getAllData()throws SQLException{
        Connection conn=QuizApplicationDBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Performance");
        ResultSet rs=ps.executeQuery();
        ArrayList<Performance> dataList=new ArrayList<>();
        while(rs.next()){
            Performance p=new Performance(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getString(7));
            dataList.add(p);
        }
        return dataList;
    }
    public static boolean setAllData(AnswerStore answerStore,Exam takeExam) throws SQLException
    {
        Connection conn=QuizApplicationDBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into Performance values(?,?,?,?,?,?,?)");
        ArrayList<Answer> answerList=answerStore.getAllAnswer();
        System.out.println("Array List size :"+answerList.size());
        int rightQuestions=0;
        int wrongQuestions=0;
        int unattampted=0;
        for(Answer ans: answerList)
        {
            if(ans.getChoosenAnswer()==null)
            {
                unattampted++;
                System.out.println("unattamp :"+unattampted);
            }
            else
            {
            
            if(ans.getCorrectAnswer().equalsIgnoreCase(ans.getChoosenAnswer())==true)
            {
                rightQuestions++;
                System.out.println("right :"+rightQuestions);
            }
            else if(ans.getCorrectAnswer().equalsIgnoreCase(ans.getChoosenAnswer())==false)
           {
               wrongQuestions++; 
               System.out.println("wrong :"+wrongQuestions);
           } 
           }
        }
        System.out.println("right :"+rightQuestions);
        System.out.println("wrong :"+wrongQuestions);
        System.out.println("unattamp :"+unattampted);
       
        
        int totalQuestion=takeExam.getQuestionNumber();
        System.out.println(" total :"+totalQuestion);
        float per=(float)(rightQuestions*100)/totalQuestion;
         ps.setString(1,UserProfile.getUserName());
         ps.setString(2, takeExam.getExamId());
         ps.setInt(3, rightQuestions);
         ps.setInt(4, wrongQuestions);
         ps.setInt(5, unattampted);
         ps.setFloat(6, per);
         ps.setString(7, takeExam.getLanguage());
         int ans=ps.executeUpdate();
         if(ans==1)
         {
             return true;
         }
         else 
             return false;
    }
}
