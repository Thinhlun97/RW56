package com.vti.shoppe.Service;

import com.vti.shoppe.Modal.Entity.Product;
import com.vti.shoppe.Modal.Request.CreateProductRequest;
import com.vti.shoppe.Modal.Request.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllP();

    Product getPById(int id);

    void createP(CreateProductRequest request);

    Product updateP(int id, UpdateProductRequest request);

    void deleteP(int id);
}
