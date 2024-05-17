/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class UserDAO {
    public CompletableFuture<List<User>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from User", User.class).list();
            }
        }).exceptionally((t) -> {
            throw new RuntimeException(t);
        });
    }
    
    public User get(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, email);
        }
    }
    
    public CompletableFuture<Void> save(User user) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException("An error occurred while saving user", e);
            }
        }).exceptionally((t) -> {
            throw new RuntimeException(t);
        });
    }
    
    public void update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            HibernateUtil.roolbackTransaction(transaction);
            throw new RuntimeException("An error occurred while updating user", e);
        }
    }
    
    public void delete(String email) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, email);
            if (user != null) {
                session.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            HibernateUtil.roolbackTransaction(transaction);
            throw new RuntimeException("An error occurred while deleting user", e);
        }
    }
}
