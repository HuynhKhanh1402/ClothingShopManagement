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
public class ImageDAO implements IDAO<Image, Long> {

    @Override
    public CompletableFuture<Image> get(Long key) {
        return CompletableFuture.supplyAsync(() -> {
            Image image;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                image = session.get(Image.class, key);
            }
            return image;
        });
    }

    @Override
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

    @Override
    public CompletableFuture<Void> save(Image image) {
        return CompletableFuture.runAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(image);
                transaction.commit();
            }
        });
    }

    @Override
    public CompletableFuture<Void> update(Image image) {
        return CompletableFuture.runAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.merge(image);
                transaction.commit();
            }
        });
    }

    @Override
    public CompletableFuture<Void> delete(Long key) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                Image image = session.get(Image.class, key);
                if (image != null) {
                    session.remove(image);
                    transaction.commit();
                }
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }

}
