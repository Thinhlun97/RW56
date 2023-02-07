package com.vti.shoppe.Modal.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "image",length = 255)
    private String  image;// ảnh đại diện sản phẩm

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductStatus status;// tình trạng sản phẩm mới hay cũ

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_unit")
    private ProductShipping_Unit shipping_unit;//đơn vị nhận vận chuyển

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;//loại sản phẩm bán

}
