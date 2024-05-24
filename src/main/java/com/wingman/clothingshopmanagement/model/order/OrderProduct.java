/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.order;

import com.wingman.clothingshopmanagement.model.product.Product;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
public class OrderProduct {
    private final Product product;
    private final double unitPrice;
    private final int quantity;
    
    public OrderProduct(Product product, double unitPrice, int quantity) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}
