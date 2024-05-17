/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wingman.clothingshopmanagement.model.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Administrator
 */
public interface IDAO<T, K> {
    public CompletableFuture<T> get(K key);
    
    public CompletableFuture<List<T>> getAll();
    
    public CompletableFuture<Void> save(T obj);
    
    public CompletableFuture<Void> update(T obj);
    
    public CompletableFuture<Void> delete(K key);
}
