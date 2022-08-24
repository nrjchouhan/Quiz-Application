/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.pojo;

/**
 *
 * @author HP
 */
public class Exam {
    private  String language;
    private  String examId;
    private  int totalQuestions;

    public Exam(String examId, String language, int totalQuestions) {
        this.language = language;
        this.examId = examId;
        this.totalQuestions = totalQuestions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getQuestionNumber() {
        return totalQuestions;
    }

    public void setQuestionNumber(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

}
