import strategies.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private Map<String, Cache> caches = new HashMap<>();

    private CacheManager() {}
    private static CacheManager INSTANCE;

    public static CacheManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CacheManager();
        }
        return INSTANCE;
    }

    public <K,V> boolean create(String cacheName, int size, EvictionStrategy<K, V> evictionStrategy) {
        Cache<K,V> cache = new Cache<>(size, evictionStrategy);
        //TODO: Check if cacheName already exists
        caches.put(cacheName, cache);
        return true;
    }

    public Object get(String cacheName, Object key) {
        //TODO: validate cache name
        return caches.get(cacheName).get(key);
    }

    public void put(String cacheName, Object key, Object value) {
        caches.get(cacheName).put(key, value);
    }

}
