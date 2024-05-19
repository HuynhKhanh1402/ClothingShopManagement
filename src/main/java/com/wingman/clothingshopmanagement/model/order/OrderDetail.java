/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.order;

import com.wingman.clothingshopmanagement.model.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "OrderDetails")
@IdClass(OrderDetailId.class)
@Getter
@Setter
public class OrderDetail {
    @Id
    @ManyToOne()
    @JoinColumn(name = "OrderID", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false, foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    private double unitPrice;
}
