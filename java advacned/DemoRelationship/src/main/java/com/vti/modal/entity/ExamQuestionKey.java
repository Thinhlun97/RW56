package com.vti.modal.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExamQuestionKey implements Serializable {

        @Column(name = "examID", nullable = false)
        private int examID;

        @Column(name = "questionID", nullable = false)
        private int questionID;

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
