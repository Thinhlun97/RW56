package com.vti.modal.entity;

import javax.persistence.*;
import java.util.BitSet;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answers")
    private int id;

    @Column(name = "Content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QuestionID",referencedColumnName = "QuestionID", nullable = false)
    private Question question;

    @Column(name = "isCorrect")
    private boolean isCorrect;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
