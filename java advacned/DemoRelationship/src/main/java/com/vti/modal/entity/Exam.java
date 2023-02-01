package com.vti.modal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamID")
    private int id;

    @Column(name = "Code", length = 10,nullable = false)
    private String code;

    @Column(name = "Title", length = 50,nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private CategoryQuestion categoryQuestion;

    @Column(name = "Duration", nullable = false)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountId")
    private Account account;

    @Column(name = "CreateDate")
    private Date createDate;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public int getDuration() {
        return duration;
    }

    public Account getAccount() {
        return account;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
