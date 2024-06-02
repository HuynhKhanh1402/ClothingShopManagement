package com.wingman.clothingshopmanagement.model.order;

import com.wingman.clothingshopmanagement.model.product.Product;
import jakarta.persistence.CascadeType;
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


@Entity
@Table(name = "OrderDetails")
@IdClass(OrderDetailId.class)
@Getter
@Setter
public class OrderDetail {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "OrderID", nullable = false, foreignKey = @ForeignKey(name = "fk_order_id"))
    private Order order;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ProductID", nullable = false, foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    private double unitPrice;
}
