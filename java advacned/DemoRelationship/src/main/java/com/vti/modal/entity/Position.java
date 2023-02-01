package com.vti.modal.entity;

import com.vti.modal.converter.ConvertPositionName;
import com.vti.modal.enumModal.PositionName;

import javax.persistence.*;

@Entity
@Table(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PositionID")
    private int id;

    @Column(name = "PositionName", unique = true,nullable = false)
//    @Enumerated(EnumType.STRING)
    @Convert(converter = ConvertPositionName.class) //sử dụng converter
    private String positionName;




}
