/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.user;

import com.wingman.clothingshopmanagement.model.image.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "Email")
    private String email;
    
    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Password")
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    private Permission permission;

    @Column(name = "LastActive")
    private Date lastActive;

    @Column(name = "AddedDate")
    private Date addedDate;
    
    @JoinColumn(name = "ImageID", nullable = true)
    @ManyToOne(targetEntity=Image.class, fetch=FetchType.LAZY)
    private Image avatar;
}
