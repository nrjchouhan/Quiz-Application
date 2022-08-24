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
import java.util.ArrayList;
import quizapplication.dbutil.QuizApplicationDBConnection;
import quizapplication.pojo.Questions;
import quizapplication.pojo.QuestionsStore;

/**
 *
 * @author HP
 */
public class QuestionDAO {
    
    public static void addQuestions(QuestionsStore qStore) throws SQLException
    {
     Connection conn=QuizApplicationDBConnection.getConnection();
     ArrayList<Questions> questionList=qStore.getAllQuestions();
     
     PreparedStatement ps=conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
     
     for(Questions question:questionList)
     {
         System.out.println("get qno : "+question.getQno());
      ps.setString(1,question.getExamId());
      ps.setInt(2, question.getQno());
      ps.setString(3, question.getQuestion());
      ps.setString(4, question.getAnswer1());
      ps.setString(5, question.getAnswer2());
      ps.setString(6, question.getAnswer3()); 
      ps.setString(7, question.getAnswer4());
      ps.setString(8,question.getCorrectAnswer());
      ps.setString(9, question.getLanguage()); 
      ps.executeUpdate(); 
     }
   
    }
 public static ArrayList<Questions> getQuestionByExamId(String examId) throws SQLException
 {
     Connection conn=QuizApplicationDBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Select * from questions where examId=? order by qno");
     ps.setString(1,examId);
     ArrayList<Questions> questionList=new ArrayList();
     ResultSet rs=ps.executeQuery();
     while(rs.next())
     {
        int qno=(rs.getInt(2));
        String question =(rs.getString(3));
        String answer1=(rs.getString(4));
        String answer2=(rs.getString(5));
        String answer3=(rs.getString(6));
        String answer4=(rs.getString(7));
        String CorrectAnswer=(rs.getString(8));
        String language=rs.getString(9);
       Questions q=new Questions(examId,qno,language,answer1,answer2,answer3,answer4,CorrectAnswer,question);
       System.out.println(examId+" "+qno+" "+language+" "+answer1+"  "+answer2+"   "+answer3+"  "+answer4+" "+CorrectAnswer+"  "+question);
       questionList.add(q);
     }
     return questionList;
     
 }
 public static void updateQuestions(QuestionsStore qStore) throws SQLException
 {
      Connection conn=QuizApplicationDBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update Questions  set question=?, answer1=?, answer2=?, answer3=?, answer4=?, correct_answer=? where examid=? and qno=?");
        ArrayList<Questions> questionList=qStore.getAllQuestions();
        System.out.println("Total Question :"+qStore.getAllQuestions());
        for(Questions q:questionList){
            System.out.println("Question getter : "+q.getQuestion());
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getAnswer1());
            ps.setString(3, q.getAnswer2());
            ps.setString(4, q.getAnswer3());
            ps.setString(5, q.getAnswer4());
            ps.setString(6, q.getCorrectAnswer());
            ps.setString(7, q.getExamId());
            ps.setInt(8, q.getQno());
            System.out.println("Question no:"+q.getQno());
            int ans=ps.executeUpdate();
            System.out.println("ans 1 :"+ans);
            System.out.println("ans 2 :"+ans);
 }
}
}
