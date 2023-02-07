package com.vti.shoppe.Controller;

import com.vti.shoppe.Modal.Entity.Product;
import com.vti.shoppe.Modal.Request.CreateProductRequest;
import com.vti.shoppe.Modal.Request.UpdateProductRequest;
import com.vti.shoppe.Service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/get-all")
    public List<Product> getAllP(){
        return service.getAllP();
    }

    @GetMapping("/{id}")
    public Product getPById(@PathVariable int id){
        return service.getPById(id);
    }

    @PostMapping("/create")
    public void createP(@RequestBody CreateProductRequest request){
        service.createP(request);
    }

    @PutMapping("/update/{id}")
    public Product updateP(@RequestBody UpdateProductRequest request, @PathVariable int id){
        return service.updateP(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteP(@PathVariable int id){
        service.deleteP(id);
    }
}
