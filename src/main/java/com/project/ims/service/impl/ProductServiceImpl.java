package com.project.ims.service.impl;

import com.project.ims.model.dto.ProductDTO;
import com.project.ims.model.entity.Product;
import com.project.ims.repository.ProductRepository;
import com.project.ims.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByProductId(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found."));
    }

    @Override
    public List<Product> filterProductsByName(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product updateProduct(int id, ProductDTO productDTO) {
        Product existingProduct = findByProductId(id);
        if (productDTO.getProductName() != null) {
            existingProduct.setProductName(productDTO.getProductName());
        }
        if (productDTO.getCategory() != null) {
            existingProduct.setCategory(productDTO.getCategory());
        }
        if (productDTO.getPrice() != null) {
            existingProduct.setPrice(productDTO.getPrice());
        }
        if (productDTO.getUnitCal() != null) {
            existingProduct.setUnitCal(productDTO.getUnitCal());
        }
        return productRepository.save(existingProduct);
    }


    @Override
    public void deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product with ID " + id + " not found.");
        }
    }
}
