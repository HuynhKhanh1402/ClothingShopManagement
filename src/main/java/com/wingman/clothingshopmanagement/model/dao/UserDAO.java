package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.product.ProductQuantity;
import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.model.user.UserSaleData;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import com.wingman.clothingshopmanagement.util.Pair;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDAO implements IDAO<User, String> {

    @Override
    public CompletableFuture<User> get(String key) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(User.class, key);
            }
        });
    }

    @Override
    public CompletableFuture<List<User>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from User", User.class).list();
            }
        });
    }

    @Override
    public CompletableFuture<Void> save(User obj) {
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
    public CompletableFuture<Void> update(User obj) {
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
    public CompletableFuture<Void> delete(String key) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                User user = session.get(User.class, key);
                if (user != null) {
                    session.remove(user);
                    transaction.commit();
                }
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }
    

    public CompletableFuture<List<UserSaleData>> getTopSeller(int maxResults) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                String hql = "SELECT new com.wingman.clothingshopmanagement.model.user.UserSaleData(U, COALESCE(SUM(OD.quantity), 0), "
                        + "COALESCE(SUM(OD.quantity * OD.unitPrice), 0)) "
                        + "FROM User U "
                        + "LEFT JOIN Order O ON O.orderBy.email = U.email "
                        + "LEFT JOIN OrderDetail OD ON OD.order.orderId = O.orderId "
                        + "GROUP BY U "
                        + "ORDER BY COALESCE(SUM(OD.quantity * OD.unitPrice), 0) DESC";
                return session.createQuery(hql, UserSaleData.class).setMaxResults(maxResults).list();
                        
            }
        });
    }
}