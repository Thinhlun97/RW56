package com.vti.shoppe.Controller;

import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Entity.Order;
import com.vti.shoppe.Modal.Request.CreateAccountRequest;
import com.vti.shoppe.Modal.Request.CreateOrderRequest;
import com.vti.shoppe.Modal.Request.UpdateAccountRequest;
import com.vti.shoppe.Modal.Request.UpdateOrderRequest;
import com.vti.shoppe.Service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/get-all")
    public List<Order> getAllO(){
        return service.getAllO();
    }

    @GetMapping("/{id}")
    public Order getAById(@PathVariable int id){
        return service.getOById(id);
    }


    @PostMapping("/create")
    public void createO(@RequestBody CreateOrderRequest request){
        service.createO(request);
    }

    @PutMapping("/update/{id}")
    public Order updateA(@RequestBody UpdateOrderRequest request, @PathVariable int id){
        return service.updateO(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteO(@PathVariable int id){
        service.deleteO(id);
    }
}
