package com.vti.shoppe.Service.impl;

import com.vti.shoppe.Modal.Entity.Product;
import com.vti.shoppe.Modal.Request.CreateProductRequest;
import com.vti.shoppe.Modal.Request.UpdateProductRequest;
import com.vti.shoppe.Repository.ProductRepository;
import com.vti.shoppe.Service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllP() {
        return repository.findAll();
    }

    @Override
    public Product getPById(int id) {
        Optional<Product> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void createP(CreateProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        repository.save(product);

    }

    @Override
    public Product updateP(int id, UpdateProductRequest request) {
        Product productDb = getPById(id);
        if(productDb != null){
            BeanUtils.copyProperties(request, productDb);

            productDb.setId(id);
            repository.save(productDb);
        }
        return null;
    }

    @Override
    public void deleteP(int id) {
        repository.deleteById(id);
    }
}
