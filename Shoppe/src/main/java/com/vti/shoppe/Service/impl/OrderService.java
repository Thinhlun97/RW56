package com.vti.shoppe.Service.impl;

import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Entity.Order;
import com.vti.shoppe.Modal.Entity.Product;
import com.vti.shoppe.Modal.Entity.StatusOrder;
import com.vti.shoppe.Modal.Request.CreateOrderRequest;
import com.vti.shoppe.Modal.Request.UpdateOrderRequest;
import com.vti.shoppe.Repository.OrderRepository;
import com.vti.shoppe.Service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;

    @Override
    public List<Order> getAllO() {
        return repository.findAll();
    }

    @Override
    public Order getOById(int id) {
        Optional<Order> optional = repository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void createO(CreateOrderRequest request) {
        Order order = new Order();
        BeanUtils.copyProperties(request,order);
        Account account = accountService.getAById(request.getOrderBy());
        Product product = productService.getPById(request.getProductId());
        if (account != null && product !=null){
            order.setOrderBy(account);
            order.setProductId(product);
            order.setCreateDate(new Date());
            order.setStatus(StatusOrder.PENDING);
            repository.save(order);
        }


    }

    @Override
    public Order updateO(int id, UpdateOrderRequest request) {
        Order orderDb = getOById(id);
        if (orderDb != null){
            BeanUtils.copyProperties(request,orderDb);
            orderDb.setId(id);
            repository.save(orderDb);
        }
        return null;
    }

    @Override
    public void deleteO(int id) {repository.deleteById(id);

    }
}
