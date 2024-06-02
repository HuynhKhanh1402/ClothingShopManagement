package com.wingman.clothingshopmanagement.model.user;


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
