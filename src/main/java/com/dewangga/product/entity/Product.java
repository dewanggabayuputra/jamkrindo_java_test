package com.dewangga.product.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name cannot be empty")
    private String name;
    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    @Pattern(regexp = "^[0-9]+$", message = "Price must be numeric")
    private String price;
//    private Double price;

    public Product(){
    }

    public Product(Long id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }
}
