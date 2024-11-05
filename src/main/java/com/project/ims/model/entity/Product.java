package com.project.ims.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/*
CREATE TABLE Product (
    productID INT PRIMARY KEY,
    productName VARCHAR(100),
    category VARCHAR(100),
    price DECIMAL(10, 2),
    unitCal VARCHAR(50)
);
 */
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "unitCal", nullable = false)
    private String unitCal;

//    @ManyToMany(mappedBy = "products")
//    @ToString.Exclude
//    private List<Import> imports;
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImport> productImports;

//    @ManyToMany(mappedBy = "products")
//    @ToString.Exclude
//    private List<Export> exports;

    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductExport> productExports;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private List<Supplier> suppliers;
}
