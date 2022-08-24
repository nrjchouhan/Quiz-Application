/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import quizapplication.dao.QuestionDAO;
import quizapplication.pojo.DisplayDateTime;
import quizapplication.pojo.Exam;
import quizapplication.pojo.Questions;
import quizapplication.pojo.QuestionsStore;
import quizapplication.pojo.User;
import quizapplication.pojo.UserProfile;

/**
 *
 * @author HP
 */
public class EditQuestionFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuestionSetFrame
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private Exam editExam;
    private QuestionsStore qStore;
    private HashMap <String,String> options;
    private int qno,pos=0;
    private String question,option1,option2,option3,option4,correctOption;
    
        public EditQuestionFrame() {
        initComponents();
        super.setLocationRelativeTo(null);
        User user=new User();
       txtAdminName.setText(DisplayDateTime.getMessage()+" "+UserProfile.getUserName());
       qStore= new QuestionsStore();
       options = new HashMap<>();
       options.put("Option 1", "Answer 1");
       options.put("Option 2", "Answer 2");
       options.put("Option 3", "Answer 3");
       options.put("Option 4", "Answer 4");
       qno=1;
       lblQno.setText(lblQno.getText()+qno);
    }
     public  EditQuestionFrame(Exam editExam)
    {
        this();
        this.editExam=editExam;
        lblTitle.setText("EDTING "+editExam.getLanguage().toUpperCase()+ " PAPER");
        loadQuestions();
        showQuestion();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        txtOption2 = new javax.swing.JTextField();
        txtOption3 = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        jcCorrectOption = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblQno = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 102, 0));
        lblTitle.setText("Edit JAVA Paper");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Logout");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 102, 0));

        txtOption1.setForeground(new java.awt.Color(255, 102, 0));

        txtOption2.setForeground(new java.awt.Color(255, 102, 0));

        txtOption3.setForeground(new java.awt.Color(255, 102, 0));

        txtOption4.setForeground(new java.awt.Color(255, 102, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Option 1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Option 2");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Opton 3");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("Option 4");

        btnNext.setBackground(new java.awt.Color(255, 51, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 51, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setText("Cancal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(255, 51, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        jcCorrectOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcCorrectOption.setForeground(new java.awt.Color(255, 51, 0));
        jcCorrectOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 0));
        jLabel11.setText("Correct Ans :");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizapplication/gui/Remainning.png"))); // NOI18N

        txtAdminName.setBackground(new java.awt.Color(0, 0, 0));
        txtAdminName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAdminName.setForeground(new java.awt.Color(255, 51, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Question", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtQuestion.setColumns(20);
        txtQuestion.setForeground(new java.awt.Color(255, 102, 0));
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        lblQno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 102, 0));
        lblQno.setText("1 : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblQno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPrevious.setBackground(new java.awt.Color(255, 51, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDone, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(btnPrevious))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel)
                            .addComponent(jcCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnNext)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    if(!validateInput())
        {
            JOptionPane.showMessageDialog(null, "Please fill all the input fields","Cannot Add Question!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String optionName=options.get(correctOption);
        System.out.println("Option 1:"+option1);
        Questions obj=new Questions(editExam.getExamId(),qno,editExam.getLanguage(),option1,option2,option3,option4,optionName,question);
        System.out.println(obj);
        qStore.removeQuestion(pos);
        qStore.setQuestionAt(pos,obj);
        pos++;
        if(pos>=qStore.getCount())
        {
            JOptionPane.showMessageDialog(null, "Your question set has been successfully updated.\nPress the DONE button to send it to the database ","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            pos=0;
            return;
        }
        showQuestion();  
        qno++;
        if(qno>qStore.getCount())
            qno=1;
        lblQno.setText("Question no:"+qno);
// TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
     EditPaperFrame paperFrame=new EditPaperFrame();
        paperFrame.setVisible(true);
        this.dispose();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if(!validateInput())
        {
            JOptionPane.showMessageDialog(null, "Please fill all the input fields","Cannot Add Question!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       String optionName=options.get(correctOption);
        System.out.println("Option 1 :"+option1);
       Questions obj=new Questions(editExam.getExamId(),qno,editExam.getLanguage(),option1,option2,option3,option4,optionName,question);
        System.out.println("Question in previous :"+obj.getQuestion());
        System.out.println("Correct ans : "+obj.getCorrectAnswer());
 
        System.out.println(optionName);
        System.out.println("obj :"+obj);
       qStore.removeQuestion(pos);
       qStore.setQuestionAt(pos,obj);
        pos--;
        if(pos<0)
        {
            JOptionPane.showMessageDialog(null, "Your question set has been successfully updated.\nPress the DONE button to send it to the database ","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            pos=qStore.getCount()-1;
        }
        showQuestion();
        qno--;
        if(qno<=0)
            qno=qStore.getCount();
        lblQno.setText("Question no:"+qno);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
   
        try{
           System.out.println("Questions Store :"+qStore);
          System.out.println(qStore.getAllQuestions());
            System.out.println("pos 1:"+qStore.getQuestion(0));
            System.out.println("pos 2:"+qStore.getQuestion(1)); 
           QuestionDAO.updateQuestions(qStore);
            JOptionPane.showMessageDialog(null, "Your question set has been successfully updated in the Database","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            EditPaperFrame paperFrame=new EditPaperFrame();
            paperFrame.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoneActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
   this.dispose();
   UserLoginFrame loginFrame=new UserLoginFrame();
   loginFrame.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox<String> jcCorrectOption;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel txtAdminName;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
public void loadQuestions()
{
    try
    {
        //JOptionPane.showMessageDialog(null, "exam ID :"+editExam.getExamId(),"Error",JOptionPane.ERROR_MESSAGE);
        ArrayList <Questions> questionList= QuestionDAO.getQuestionByExamId(editExam.getExamId());
               for(Questions obj:questionList)
                  {
                      System.out.println("Question : "+obj.getQuestion());
                    qStore.addQuestion(obj);
                  }
    }
    catch(SQLException sq)
    {
        JOptionPane.showMessageDialog(null, "Exception While Loading data "+sq, option1, HEIGHT);
    }
}
public String getKeyFromValue(String value)
{
    Set<String> keys=options.keySet();
    for(String key: keys)
    {
        String currValue=options.get(key);
        if(currValue.equals(value))
        {
            return key;
        }
     
    }
       return null;
}
public void showQuestion()
{
    try{
    Questions q=qStore.getQuestion(pos);
    System.out.println("Question at "+pos+""+q.getQuestion());
    txtQuestion.setText(q.getQuestion());
    txtOption1.setText(q.getAnswer1());
    txtOption2.setText(q.getAnswer2());
    txtOption3.setText(q.getAnswer3());
    txtOption4.setText(q.getAnswer4());
    String correctAnswer=q.getCorrectAnswer();
    System.out.println(correctAnswer);
    String correctOption1=getKeyFromValue(correctAnswer);
    System.out.println(correctOption1);
    jcCorrectOption.setSelectedItem(correctOption1);
    }
    catch(Exception e)
    {
        System.out.println("Exception in show Questions"+e);
    }
}
private boolean validateInput()
{
    if(txtQuestion.getText().isEmpty()||txtOption1.getText().isEmpty()||txtOption2.getText().isEmpty()||txtOption3.getText().isEmpty()
            ||txtOption4.getText().isEmpty())
        return false;
    else
    {
        question=txtQuestion.getText();
        option1=txtOption1.getText();
        option2=txtOption2.getText();
        option3=txtOption3.getText();
        option4=txtOption4.getText();
        correctOption=jcCorrectOption.getSelectedItem().toString();
        
        return true;
    }   
}
}
