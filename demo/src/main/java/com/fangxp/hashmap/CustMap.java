package com.fangxp.hashmap;

/**
 * Created by michael on 2017/1/22.
 */
public interface CustMap<K,V> {

    public V put(K k, V v);

    public V get(K k);

    public int size();

    public interface entry<K, V>{
        public K getKey();

        public V getValue();
    }

}
