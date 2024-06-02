package com.wingman.clothingshopmanagement.util;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 * @param <K>
 * @param <V>
 */
@Getter
@Setter
public class Pair<K, V> {
    private K first;
    private V second;
    
    public Pair(K k, V v) {
        this.first = k;
        this.second = v;
    }
}
