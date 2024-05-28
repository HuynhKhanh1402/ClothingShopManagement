/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class ProductDAO implements IDAO<Product, Long>{

    @Override
    public CompletableFuture<Product> get(Long key) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(Product.class, key);
            }
        });
    }

    @Override
    public CompletableFuture<List<Product>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from Product", Product.class).list();
            }
        });
    }

    @Override
    public CompletableFuture<Void> save(Product obj) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.persist(obj);
                transaction.commit();
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public CompletableFuture<Void> update(Product obj) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.merge(obj);
                transaction.commit();
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public CompletableFuture<Void> delete(Long key) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                Product product = session.get(Product.class, key);
                if (product != null) {
                    session.remove(product);
                    transaction.commit();
                }
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }
    
}
