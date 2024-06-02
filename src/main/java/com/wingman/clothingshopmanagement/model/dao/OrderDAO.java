package com.wingman.clothingshopmanagement.model.dao;

import com.wingman.clothingshopmanagement.model.order.Order;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import com.wingman.clothingshopmanagement.view.panel.revenue.RevenueChartData;
import com.wingman.clothingshopmanagement.view.panel.revenue.RevenueMonthy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class OrderDAO implements IDAO<Order, Long> {

    @Override
    public CompletableFuture<Order> get(Long key) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(Order.class, key);
            }
        });
    }

    @Override
    public CompletableFuture<List<Order>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from Order", Order.class).list();
            }
        });
    }

    @Override
    public CompletableFuture<Void> save(Order obj) {
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
    public CompletableFuture<Void> update(Order obj) {
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
                Order order = session.get(Order.class, key);
                if (order != null) {
                    session.remove(order);
                    transaction.commit();
                }
            } catch (Exception e) {
                HibernateUtil.roolbackTransaction(transaction);
                throw new RuntimeException(e);
            }
        });
    }
    
    public CompletableFuture<Double> getRevenue(Date from, Date to) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()){
                String hql = "SELECT SUM(OD.unitPrice * OD.quantity) AS Revenue FROM OrderDetail OD JOIN Order O ON OD.order.orderId = O.orderId WHERE O.orderDate >= :from_date AND O.orderDate < :to_date";
                return session.createQuery(hql, Double.class)
                        .setParameter("from_date", from)
                        .setParameter("to_date", to)
                        .getSingleResult();
            }
        });
    }
    
    public CompletableFuture<Long> getOrderedProducts(Date from, Date to) {
        return CompletableFuture.supplyAsync(() -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()){
                String hql = "SELECT SUM(OD.quantity) AS OrderedProducts FROM OrderDetail OD JOIN Order O ON OD.order.orderId = O.orderId WHERE O.orderDate >= :from_date AND O.orderDate < :to_date";
                return session.createQuery(hql, Long.class)
                        .setParameter("from_date", from)
                        .setParameter("to_date", to)
                        .getSingleResult();
            }
        });
    }
    
    public CompletableFuture<RevenueChartData> getRevenueChartData() {
        return CompletableFuture.supplyAsync(() -> {
            String hql = "SELECT SUM(OD.unitPrice * OD.quantity) AS Revenue FROM OrderDetail OD JOIN Order O ON OD.order.orderId = O.orderId WHERE MONTH(O.orderDate) = :month AND YEAR(O.orderDate) = :year";
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                List<RevenueMonthy> data = new ArrayList<>();
                LocalDate currentDate = LocalDate.now();

                for (int i = 0; i < 12; i++) {
                    if (i != 0) {
                        currentDate = currentDate.minusMonths(1);
                    }
                    int month = Integer.parseInt(currentDate.format(DateTimeFormatter.ofPattern("M")));
                    int year = Integer.parseInt(currentDate.format(DateTimeFormatter.ofPattern("yyyy")));
                    
                    Double revenue = session
                            .createQuery(hql, Double.class)
                            .setParameter("month", month)
                            .setParameter("year", year)
                            .getSingleResult();
                    revenue = revenue == null ? 0D : revenue;
                    data.add(new RevenueMonthy(month, year, revenue));
                }
                
                return new RevenueChartData(data);
            }
        });
    }
}
