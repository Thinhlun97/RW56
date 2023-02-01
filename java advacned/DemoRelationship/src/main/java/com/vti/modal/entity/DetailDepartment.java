package com.vti.modal.entity;

import javax.persistence.*;

@Entity
@Table(name = "DeltailDepartment")
public class DetailDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeltailDepartmentId")
    private int id;

    @OneToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID" )
    private Department departmentID;

    @ManyToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private int emulationPoint;


}
