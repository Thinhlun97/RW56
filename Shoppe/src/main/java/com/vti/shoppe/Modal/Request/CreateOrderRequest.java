package com.vti.shoppe.Modal.Request;

import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Entity.Product;
import com.vti.shoppe.Modal.Entity.StatusOrder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CreateOrderRequest {

    private int orderBy;//người order

    private int productId;

    private int quantity;//số lượng sản phẩm đã order

    private StatusOrder status;
}
