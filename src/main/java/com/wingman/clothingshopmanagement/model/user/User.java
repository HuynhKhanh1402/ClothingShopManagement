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
    
    @JoinColumn(name = "UserAvatar", nullable = true)
    @ManyToOne(targetEntity=Image.class, fetch=FetchType.EAGER)
    private Image avatar;
}
