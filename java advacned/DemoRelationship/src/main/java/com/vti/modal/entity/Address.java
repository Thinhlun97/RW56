package com.vti.modal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int id;

    @Column(name = "Address", length = 100, unique = true, nullable = false)
    private String addressName;

    @OneToMany(mappedBy = "address")
    private List<DetailDepartment> detailDepartments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {

        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
