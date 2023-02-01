package com.vti.modal.entity;

import javax.persistence.*;

@Entity
@Table(name = "`Manager`")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID" )
    private Account account;


    @Column(name = "ManagementNumberOfYear", nullable = false)
    private int managementNumberOfYear;


}
