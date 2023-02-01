package com.vti.modal.entity;

import com.vti.modal.converter.ConvertTypeName;

import javax.persistence.*;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID")
    private int id;

    @Column(name = "TypeName")
    @Convert(converter = ConvertTypeName.class)
    private int typeName;

    public int getId() {
        return id;
    }

    public int getTypeName() {
        return typeName;
    }


}
