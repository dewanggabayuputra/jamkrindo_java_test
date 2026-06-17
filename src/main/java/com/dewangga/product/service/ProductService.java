package com.dewangga.product.service;

import com.dewangga.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import com.dewangga.product.repository.ProductRepository;
import com.dewangga.product.entity.Product;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }
    public Product getProductById(Long id) {
        Product product = productRepository.findProductById(id);

        return product;
    }
}
