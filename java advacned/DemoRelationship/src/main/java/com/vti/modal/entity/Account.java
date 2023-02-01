package com.vti.modal.entity;

import com.vti.modal.enumModal.PositionName;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private int id;

    @Column(name = "Email", length = 50,unique = true,nullable = false,updatable = false)
    private String email;

    @Column(name = "Username", length = 50,unique = true,nullable = false,updatable = false)
    private String userName;

    @Column(name = "FirstName", length = 50,nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50,nullable = false)
    private String lastName;

    @Formula("CONCAT (firstName, ' ' , lastName)")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID" )
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    private Position position;


    @ManyToOne
    @JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
    private Salary salary;

    @Column(name = "CreateDate")
    private Date createDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


}
