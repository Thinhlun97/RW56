package com.vti.modal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID")
    private int id;

    @Column(name = "GroupName",length = 50 ,unique = true,nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID")
    private Account account;

    @Column(name = "CreateDate")
    private Date createDate;

    @PrePersist
    public void generateCreateDate(){
        this.createDate = new Date();
    }

}
