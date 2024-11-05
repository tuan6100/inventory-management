package com.project.ims.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/*
CREATE TABLE Inventory (
    productID INT PRIMARY KEY,
    lastUpdate DATE,
    quantity INT,
    FOREIGN KEY (productID) REFERENCES Product(productID)
);
 */
@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    private int inventoryID;

    @Column(name = "lastUpdate", nullable = false)
    private Date lastUpdate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

//    @Column(columnDefinition = "FOREIGN KEY (productID) REFERENCES Product(productID)", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "productID", referencedColumnName = "productID", nullable = false)
    private Product product;
}
