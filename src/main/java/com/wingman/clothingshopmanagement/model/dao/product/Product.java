/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao.product;

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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;
    
    @Column(name = "Name")
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Email", nullable = false, 
        foreignKey = @ForeignKey(name = "AddedBy"))
    @Column(name = "AddedBy")
    private User addedBy;
    
    @Column(name = "Description")
    private String desciption;
    
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ImageID", nullable = false, 
        foreignKey = @ForeignKey(name = "ProductImage"))
    @Column(name="ProductImage", nullable = true)
    private Image productImage;
    
}
