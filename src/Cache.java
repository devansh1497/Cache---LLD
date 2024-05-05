import strategies.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V>{

    int size;
    Map<K, V> entries = new HashMap<>();
    EvictionStrategy<K,V> evictionStrategy;

    public Cache(int size, EvictionStrategy<K, V> evictionStrategy) {
        this.size = size;
        this.evictionStrategy = evictionStrategy;
    }

    public V get(K key) {
        if(entries.get(key) == null) {
            return null;
        }
        V val = entries.get(key);
        evictionStrategy.accessed(key, val);
        return val;
    }

    public void put(K key, V value) {
        evictionStrategy.accessed(key, value);
        K evictedKey = evictionStrategy.evict();
        entries.remove(evictedKey);
        entries.put(key, value);
    }
}
