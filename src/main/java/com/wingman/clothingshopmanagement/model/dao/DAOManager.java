package com.wingman.clothingshopmanagement.model.dao;

import lombok.Getter;

@Getter
public class DAOManager {

    private static DAOManager instance;

    private final UserDAO userDAO;
    private final ImageDAO imageDAO;

    private DAOManager() {
        this.userDAO = new UserDAO();
        this.imageDAO = new ImageDAO();
    }

    public static DAOManager getInstance() {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }
}