package com.wingman.clothingshopmanagement.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQuantity {
    private Product product;
    private long totalQuantity;

    public ProductQuantity(Product product, long totalQuantity) {
        this.product = product;
        this.totalQuantity = totalQuantity;
    }

}