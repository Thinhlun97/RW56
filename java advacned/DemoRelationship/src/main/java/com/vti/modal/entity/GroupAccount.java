package com.vti.modal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GroupAccount")
public class GroupAccount {

    @EmbeddedId
    private GroupAccountKey id;


    @Column(name = "JoinDate")
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID" )
    private Group group;

    @ManyToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account account;

    @PrePersist
    public void generateCreateDate(){
        this.joinDate = new Date();
    }

    public GroupAccountKey getId() {
        return id;
    }

    public void setId(GroupAccountKey id) {
        this.id = id;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
