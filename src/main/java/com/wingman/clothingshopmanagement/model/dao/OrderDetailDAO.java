/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.order.Order;
import com.wingman.clothingshopmanagement.model.order.OrderDetail;
import com.wingman.clothingshopmanagement.model.order.OrderDetailId;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Administrator
 */
public class OrderDetailDAO implements IDAO<OrderDetail, OrderDetailId>{

    @Override
    public CompletableFuture<OrderDetail> get(OrderDetailId key) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(OrderDetail.class, key);
            }
        });
    }

    @Override
    public CompletableFuture<List<OrderDetail>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from OrderDetial", OrderDetail.class).list();
            }
        });
    }
    
    public CompletableFuture<List<OrderDetail>> getAll(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Query<OrderDetail> query = session.createQuery("from OrderDetail O WHERE O.order.orderId = :oid", OrderDetail.class);
                query.setParameter("oid", order.getOrderId());
                return query.list();
            }
        });
    }
    
    public CompletableFuture<Double> getTotal(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            return getAll(order).join().stream().map((t) -> {
                return t.getQuantity() * t.getUnitPrice();
            }).reduce(0D, (a, b) -> a + b);
        });
    }

    @Override
    public CompletableFuture<Void> save(OrderDetail obj) {
        return CompletableFuture.runAsync(() -> {
            Session session = null;
            Transaction transaction;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.saveOrUpdate(obj);
                transaction.commit();
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            } finally {
                if (session != null) {
                    session.close();
                }
            }
//            Transaction transaction = null;
//            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//                transaction = session.beginTransaction();
//                
//            } catch (Exception e) {
//                HibernateUtil.roolbackTransaction(transaction);
//                throw new RuntimeException(e);
//            }
        });
    }

    @Override
    public CompletableFuture<Void> update(OrderDetail obj) {
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
    public CompletableFuture<Void> delete(OrderDetailId key) {
        return CompletableFuture.runAsync(() -> {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                OrderDetail orderDetail = session.get(OrderDetail.class, key);
                if (orderDetail != null) {
                    session.remove(orderDetail);
                    transaction.commit();
                }
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }
    
}
