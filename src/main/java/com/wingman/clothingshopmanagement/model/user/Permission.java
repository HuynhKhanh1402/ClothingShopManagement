/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.user;

/**
 *
 * @author Administrator
 */
public enum Permission {
    ADMINISTRATOR("Administrator"),
    MODERATOR("Moderator");
    
    private final String text;
    
    private Permission(String text) {    
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
