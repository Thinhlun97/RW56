package com.vti.shoppe.Modal.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "`Order`")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_date")
    private Date createDate;// ngày order

    @ManyToOne
    @JoinColumn(name = "order_by")
    private Account orderBy;//người order

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "quantity")
    private int quantity;//số lượng sản phẩm đã order

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrder status;
}
