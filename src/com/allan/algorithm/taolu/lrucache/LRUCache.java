package com.allan.algorithm.taolu.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    static class CacheData {
        private String key;
        private String value;

        public CacheData(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CacheData cacheData = (CacheData) o;

            if (!key.equals(cacheData.key)) return false;
            return value.equals(cacheData.value);

        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }

    private LinkedList<CacheData> cacheDataLinkedList;
    private Map<String, CacheData> cache;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheDataLinkedList = new LinkedList<>();
        this.cache = new HashMap<>();
    }

    public void put(String key, String value) {
        CacheData cacheData;
        if (cache.containsKey(key)) {
            cacheData = cache.get(key);
            cacheData.key = key;
            cacheData.value = value;
            this.cacheDataLinkedList.remove(cacheData);
        } else {
            cacheData = new CacheData(key, value);
            cache.put(key, cacheData);
        }
        this.cacheDataLinkedList.addFirst(cacheData);

        if (this.cacheDataLinkedList.size() > capacity) {
            CacheData last = this.cacheDataLinkedList.getLast();
            this.cache.remove(last.key);
            this.cacheDataLinkedList.removeLast();

        }
    }

    public String get(String key) {
        if(cache.containsKey(key)) {
            CacheData cacheData = cache.get(key);
            this.cacheDataLinkedList.remove(cacheData);
            this.cacheDataLinkedList.addFirst(cacheData);
            return cacheData.value;
        }
        return null;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("cfo", "John Doe");
        cache.put("cto", "Jane Doe");
        cache.put("coo", "Bob Doe"); // coo, cto, cfo

        System.out.println( "coo is: " + cache.get("cfo")); // cfo, coo, cto

        cache.put("vp", "Jack Doe"); // vp, cfo, coo, cto
        cache.put("svp", "Jeremy Doe"); // svp, vp, cfo, coo

        System.out.println( "cto should return null:  " + (cache.get("cto") == null));

        System.out.println( "coo is: " + cache.get("coo"));  // coo, svp, vp, cfo

    }
}
