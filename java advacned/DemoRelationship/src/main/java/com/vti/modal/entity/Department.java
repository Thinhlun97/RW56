package com.vti.modal.entity;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private int id;

    @Column(name = "Department",length = 30,unique = true)
    private String DepartmentName;

    @OneToOne(mappedBy = "departmentID")
    private DetailDepartment detailDepartment;

//    @OneToOne(mappedBy = "departmentID")
//    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
