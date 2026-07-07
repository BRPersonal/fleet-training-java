package com.fleet.training.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TTLCache<K,V>
{
    private record CacheEntry<V>(V value, long expiringAt)
    {
        public boolean isExpired() {
            return System.currentTimeMillis() > expiringAt;
        }
    }
    private final Map<K,CacheEntry<V>> cache  = new ConcurrentHashMap<>();
    private final long ttlMillis;

    public TTLCache(long ttlMillis) {
        this.ttlMillis = ttlMillis;
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get (key) ;
        if (entry == null || entry. isExpired()) {
            cache.remove(key);
            return null;
        }
        return entry.value;
    }

    public void put (K key, V value) {
        CacheEntry<V> entry = new CacheEntry<>(value, System.currentTimeMillis() + ttlMillis);
        cache.put(key, entry);
    }
}
