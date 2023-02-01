package com.vti.modal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private int id;

    @Column(name = "Content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private CategoryQuestion categoryQuestion;

    @ManyToOne
    @JoinColumn(name = "TypeID", referencedColumnName = "TypeID")
    private TypeQuestion typeQuestion;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID",unique = true,updatable = false)
    private Account account;


    @Column(name = "CreateDate")
    private Date createDate;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public Account getAccount() {
        return account;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
