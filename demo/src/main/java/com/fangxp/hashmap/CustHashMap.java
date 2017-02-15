package com.fangxp.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 2017/1/22.
 */
public class CustHashMap<K,V> implements CustMap<K,V> {

    private static int defaultLength = 16;

    private static Double defaultLoader = 0.75;

    private Entry<K,V>[] table = null;

    private int size = 0;

    public CustHashMap(int length, Double loader) {
        this.defaultLength = length;
        this.defaultLoader = loader;
        table = new Entry[defaultLength];

    }


    public CustHashMap() {
        this(defaultLength, defaultLoader);
    }

    @Override
    public V put(K k, V v) {

        //判断是否需要扩容
        if (size >= defaultLength * defaultLoader) {
            up2size();
        }

        //根据key和hash函数计算出数组下标
        int index = getIndex(k);

        Entry<K, V> entry = table[index];

        //判断table对应下标是否已经存在值
        if (entry != null) {
            //index不为空，说明index位置有元素，采用链表形式存储，用新值替换原来元素，用next指针指向老数据
            table[index] = newEntry(k, v, entry);
        }else{
            table[index] = newEntry(k, v, null);
            size++;
        }

        return table[index].getValue();
    }

    private void up2size() {
        Entry[] newTable = new Entry[2*defaultLength];
        //初始化新table
        initNewTable(newTable);

    }

    private void initNewTable(Entry[] newTable) {
        //找出原table中所有元素集合
        List<Entry<K, V>> list = new ArrayList();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            findEntryByNext(table[i],list);
        }

        //将原table中所有元素从新散列到newTable中
        if (list.size() <= 0) {
            return;
        }
        
        size = 0;
        defaultLength = 2*defaultLength;
        table = newTable;

        for (Entry<K, V> entry : list) {
            if (entry.next != null) {
                entry.next = null;
            }
            put(entry.getKey(), entry.getValue());
        }


    }

    private void findEntryByNext(Entry<K, V> entry, List<Entry<K, V>> list) {

        if(entry.next == null){
            list.add(entry);
        }else {
            list.add(entry);
            findEntryByNext(entry.next, list);
        }

    }

    private Entry<K, V> newEntry(K k, V v, Entry<K, V> next) {
        return new Entry(k,v,next);
    }

    private int getIndex(K k) {
        int m  = defaultLength;

        int index = k.hashCode() % m;

        return index > 0 ? index : -index;
    }

    @Override
    public V get(K k) {
        if (k == null) {
            return null;
        }

        //根据key和hash函数计算出key所对应的下标
        int index = getIndex(k);

        if (table[index] == null) {
            return null;
        }

        return findValueByEqualKey(k,table[index]);
    }

    private V findValueByEqualKey(K k, Entry<K, V> entry) {
        if (k.equals(entry.getKey())) {
            return entry.getValue();
        }else{
            if (entry.next != null) {
                return findValueByEqualKey(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K,V> implements CustMap.entry<K,V>{

        K k;

        V v;

        Entry<K,V> next;

        public Entry(K k,V v,Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }


    }
}
