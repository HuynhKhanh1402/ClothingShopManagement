/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.image.Image;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class ImageDAO {
    public CompletableFuture<Image> get(long id) {
        return CompletableFuture.supplyAsync(() -> {
            Image image;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                image = session.get(Image.class, id);
            }
            return image;
        });
    }

    public CompletableFuture<List<Image>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            List<Image> images;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                CriteriaQuery<Image> criteriaQuery = session.getCriteriaBuilder().createQuery(Image.class);
                criteriaQuery.from(Image.class);
                images = session.createQuery(criteriaQuery).getResultList();
            }
            return images;
        });
    }

    public CompletableFuture<Void> save(Image image) {
        return CompletableFuture.runAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(image);
                transaction.commit();
            }
        });
    }

    public CompletableFuture<Void> update(Image image) {
        return CompletableFuture.runAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.merge(image);
                transaction.commit();
            }
        });
    }

    public CompletableFuture<Void> delete(Image image) {
        return CompletableFuture.runAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.remove(image);
                transaction.commit();
            }
        });
    }
}
