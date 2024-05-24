package com.wingman.clothingshopmanagement.model.dao;

import lombok.Getter;

@Getter
public class DAOManager {

    private static DAOManager instance;

    private final UserDAO userDAO;
    private final ImageDAO imageDAO;
    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;
    private final OrderDetailDAO orderDetailDAO;

    private DAOManager() {
        this.userDAO = new UserDAO();
        this.imageDAO = new ImageDAO();
        this.productDAO = new ProductDAO();
        this.orderDAO = new OrderDAO();
        this.orderDetailDAO = new OrderDetailDAO();
    }

    public static DAOManager getInstance() {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }
}