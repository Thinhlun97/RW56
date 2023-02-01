package com.vti.modal.entity;

import com.vti.modal.converter.ConvertSalaryName;
import com.vti.modal.enumModal.SalaryName;

import javax.persistence.*;

@Entity
@Table(name = "`Salary`")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalaryID")
    private int id;

    @Column(name = "SalaryName")
    @Convert(converter = ConvertSalaryName.class)
    private int salaryName;

    public int getId() {
        return id;
    }


    public int getSalaryName() {
        return salaryName;
    }

}
