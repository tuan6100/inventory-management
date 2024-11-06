package com.project.ims.service;

import com.project.ims.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product findByProductId(int id);
    List<Product> findProductsByName(String name);
    Page<Product> findAll(Pageable pageable);
    void deleteProduct(int id);
}
