package com.vti.modal.entity;

import javax.persistence.*;

@Entity
@Table(name = "`Employee`")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int id;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private int workingNumberOfYear;

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID" )
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(int workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
