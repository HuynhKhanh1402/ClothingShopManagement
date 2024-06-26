package com.wingman.clothingshopmanagement.model.product;

import com.wingman.clothingshopmanagement.model.image.Image;
import com.wingman.clothingshopmanagement.model.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long productId;
    
    @Column(name = "Name")
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "AddedBy", nullable = true, 
        foreignKey = @ForeignKey(name = "AddedBy"))
    private User addedBy;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Price")
    private double price;
    
    @Column(name = "Stock")
    private int stock;
    
    @Column(name = "Brand")
    private String brand;
    
    @Column(name = "Size")
    private String size;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;
    
    @Column(name = "Color")
    private String color;
    
    @Column(name = "AddedDate")
    private Date addedDate;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "ProductImage", nullable = true, 
        foreignKey = @ForeignKey(name = "ProductImage"))
    private Image productImage;
}
