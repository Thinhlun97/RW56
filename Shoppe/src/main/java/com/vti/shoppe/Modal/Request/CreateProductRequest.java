package com.vti.shoppe.Modal.Request;

import com.vti.shoppe.Modal.Entity.ProductShipping_Unit;
import com.vti.shoppe.Modal.Entity.ProductStatus;
import com.vti.shoppe.Modal.Entity.ProductType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CreateProductRequest {
    private String name;

    private String  image;// ảnh đại diện sản phẩm

    private int price;

    private ProductStatus status;// tình trạng sản phẩm mới hay cũ

    private ProductShipping_Unit shipping_unit;//đơn vị nhận vận chuyển

    private ProductType type;//loại sản phẩm bán
}
