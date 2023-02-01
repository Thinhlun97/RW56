package com.vti.modal.entity;

import javax.persistence.*;

@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion {

    @EmbeddedId
    private ExamQuestionKey id;

    @ManyToOne
    @JoinColumn(name = "ExamID", referencedColumnName = "ExamID" )
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    private Question question;

    public ExamQuestionKey getId() {
        return id;
    }

    public Exam getExam() {
        return exam;
    }

    public Question getQuestion() {
        return question;
    }
}
