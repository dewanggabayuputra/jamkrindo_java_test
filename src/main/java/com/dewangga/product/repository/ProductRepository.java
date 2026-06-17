package com.dewangga.product.repository;

import com.dewangga.product.entity.Product;
import com.dewangga.product.exception.ProductNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveProduct(Product product) {
        return jdbcTemplate.update("INSERT INTO products (name, price) VALUES (?, ?)",
        product.getName(),
                product.getPrice());
    }
    public Product findProductById(Long id) {
        try {
            Product product = jdbcTemplate.queryForObject(
                    "SELECT * FROM products WHERE id = ?",
                    (rs, rowNum) -> new Product(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("price")
                    ),id
            );

            return product;
        } catch (EmptyResultDataAccessException e) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }
}