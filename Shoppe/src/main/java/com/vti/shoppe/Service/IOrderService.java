package com.vti.shoppe.Service;

import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Entity.Order;
import com.vti.shoppe.Modal.Request.CreateAccountRequest;
import com.vti.shoppe.Modal.Request.CreateOrderRequest;
import com.vti.shoppe.Modal.Request.UpdateAccountRequest;
import com.vti.shoppe.Modal.Request.UpdateOrderRequest;

import java.util.List;

public interface IOrderService {
    List<Order> getAllO();

    Order getOById(int id);

    void createO(CreateOrderRequest request);

    Order updateO(int id, UpdateOrderRequest request);

    void deleteO(int id);
}
